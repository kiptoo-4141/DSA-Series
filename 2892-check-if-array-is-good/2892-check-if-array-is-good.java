class Solution {
    public boolean isGood(int[] nums) {
        int n = nums.length - 1;
        Map<Integer, Integer> countMap = new HashMap<>();

        for(int num : nums){
            if(num > n){
                return false;
            }
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        for(int i = 1; i < n; i++){
            if(countMap.getOrDefault(i, 0) != 1){
                return false;
            }
        }

        if(countMap.getOrDefault(n, 0) != 2){
            return false;
        }

        if (countMap.size() != n){

            return false;
        }
        return true;
    }
}