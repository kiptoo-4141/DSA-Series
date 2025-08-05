class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];

        for(int i = 1; i < nums.length; i++){
            prefixSum[i] = nums[i] + prefixSum[i-1];
        }

        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(prefixSum[i] ==k){
                count++;
            }
            for(int j = 0; j < i; j++){
                if(prefixSum[i] - prefixSum[j] == k){
                    count++;
                }
            }
        }

        return count;
    }
}