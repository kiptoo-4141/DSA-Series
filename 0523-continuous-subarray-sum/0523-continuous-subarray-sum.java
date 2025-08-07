class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
       Map<Integer, Integer> remainderMap = new HashMap<>();
       remainderMap.put(0, -1);

       int comulativeSum = 0;

       for(int i = 0; i < nums.length; i++){
            comulativeSum += nums[i];

            int remainder = k == 0 ? comulativeSum : comulativeSum % k;

            if(remainderMap.containsKey(remainder)){
                int prevIndex = remainderMap.get(remainder);

                if(i - prevIndex >= 2){
                    return true;
                }
                
            } else {
                remainderMap.put(remainder, i);
            }
        } 

        return false;
    }
}