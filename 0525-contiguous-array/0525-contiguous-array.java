class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int Sum = 0, maxLength = 0;

        for(int i = 0; i < nums.length; i++){
            Sum += nums[i] == 0 ? -1 : 1;

            if(map.containsKey(Sum)){
                int prevIndex = map.get(Sum);
                maxLength = Math.max(maxLength, i - prevIndex);
            } 
            else {
                map.put(Sum, i);
            }
        }
        return maxLength;
    }
}