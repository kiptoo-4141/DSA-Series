class Solution {
    public int maxChunksToSorted(int[] arr) {
         int chunks = 0;
        int maxSoFar = 0;

        for (int i = 0; i < arr.length; i++) {
            maxSoFar = Math.max(maxSoFar, arr[i]);
            // If all numbers up to index i are ≤ i and max equals i,
            // we can safely make a chunk here
            if (maxSoFar == i) {
                chunks++;
            }
        }
        return chunks;
    }
}