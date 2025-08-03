class Solution {
    public int minRemoval(int[] nums, int k) {
        if(nums.length == 1){
            return 0;
        }

        Arrays.sort(nums);
        int maxLen = 0;
        int start = 0;
        int end = 0;

        while(end < nums.length){
           while((long)nums[end] > (long)k*nums[start]){
            start++;
           }

            maxLen = Math.max(maxLen, end - start + 1);
            end++;
        }
        return nums.length - maxLen;
    }
}