class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        
        List<Integer> subsequence = new ArrayList<>();
        int subseqSum = 0;
        
        for (int i = n - 1; i >= 0; i--) {
            subseqSum += nums[i];
            subsequence.add(nums[i]);
            if (subseqSum > totalSum - subseqSum) {
                break;
            }
        }
        
        return subsequence;
    }
}