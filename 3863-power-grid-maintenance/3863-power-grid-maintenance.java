class Solution {
    int[] parent;
    TreeSet<Integer>[] onlineStations;

    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        parent = new int[c + 1];
        for (int i = 1; i <= c; i++) {
            parent[i] = i;
        }

        // Initialize the TreeSet array before union operations
        onlineStations = new TreeSet[c + 1];
        for (int i = 1; i <= c; i++) {
            onlineStations[i] = new TreeSet<>();
            onlineStations[i].add(i); // All stations are initially online
        }

        // Now it's safe to union
        for (int[] edge : connections) {
            union(edge[0], edge[1]);
        }

        List<Integer> res = new ArrayList<>();

        for (int[] q : queries) {
            int type = q[0], x = q[1];
            int root = find(x);

            if (type == 1) { // maintenance check
                if (onlineStations[root].contains(x)) {
                    res.add(x);
                } else if (!onlineStations[root].isEmpty()) {
                    res.add(onlineStations[root].first());
                } else {
                    res.add(-1);
                }
            } else if (type == 2) { // go offline
                onlineStations[root].remove(x);
            }
        }

        return res.stream().mapToInt(i -> i).toArray();
    }

    private int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    private void union(int a, int b) {
        int rootA = find(a), rootB = find(b);
        if (rootA == rootB) return;

        // Always merge the smaller root into the larger one for consistency
        if (rootA < rootB) {
            parent[rootB] = rootA;
            onlineStations[rootA].addAll(onlineStations[rootB]);
            onlineStations[rootB] = null; // Optional: help GC
        } else {
            parent[rootA] = rootB;
            onlineStations[rootB].addAll(onlineStations[rootA]);
            onlineStations[rootA] = null; // Optional
        }
    }
}
