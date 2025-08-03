class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int n = fruits.length;
        int maxFruits = 0, total = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            total += fruits[right][1];

            while (left <= right && !canReach(fruits, startPos, k, left, right)) {
                total -= fruits[left][1];
                left++;
            }

            maxFruits = Math.max(maxFruits, total);
        }

        return maxFruits;
    }

    private boolean canReach(int[][] fruits, int startPos, int k, int left, int right) {
        int leftPos = fruits[left][0];
        int rightPos = fruits[right][0];

        // two strategies:
        // 1. go left first, then right
        // 2. go right first, then left

        int costLeftFirst = Math.abs(startPos - leftPos) + (rightPos - leftPos);
        int costRightFirst = Math.abs(startPos - rightPos) + (rightPos - leftPos);

        return Math.min(costLeftFirst, costRightFirst) <= k;
    }
}