class Solution {
    private int[] memo;
    public int numSquares(int n) {
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return helper(n);
    }

    private int helper(int n) {
        if (n == 0) return 0;
        if (memo[n] != -1) return memo[n];

        int minCount = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            int square = i * i;
            minCount = Math.min(minCount, 1 + helper(n - square));
        }

        memo[n] = minCount;
        return minCount;
    }
}