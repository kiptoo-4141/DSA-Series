class Solution {
    private Map<String, Integer> memo;

    public int findTargetSumWays(int[] nums, int target) {
        memo = new HashMap<>();
        return dfs(nums, 0, 0, target);
    }

    private int dfs(int[] nums, int index, int currentSum, int target) {
        if (index == nums.length) {
            return currentSum == target ? 1 : 0;
        }

        String key = index + "," + currentSum;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int add = dfs(nums, index + 1, currentSum + nums[index], target);

        int subtract = dfs(nums, index + 1, currentSum - nums[index], target);

        int totalWays = add + subtract;
        memo.put(key, totalWays);
        return totalWays;
    }
}