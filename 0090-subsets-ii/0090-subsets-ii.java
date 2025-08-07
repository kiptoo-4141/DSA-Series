class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(0, nums, result, new ArrayList<>());
        return result;
    }

    private void backtrack(int start, int[] nums, List<List<Integer>> result, List<Integer> current){
        result.add(new ArrayList<>(current));

        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i - 1]){
                continue;
            }

            current.add(nums[i]);
            backtrack(i + 1, nums, result, current);
            current.remove(current.size() - 1);
        }
    }
}