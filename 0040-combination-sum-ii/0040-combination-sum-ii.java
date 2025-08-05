class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        Backtrack(candidates, target, 0, new ArrayList<>(), result);

        return result;
    }

    private void Backtrack(int[] candidates, int target, int start, List<Integer> combination, List<List<Integer>> result){

        if(target == 0){
            result.add(new ArrayList<>(combination));
        }
        for(int i = start; i < candidates.length; i++){
            if(i > start && candidates[i] == candidates[i-1]){
                continue;
            }

            if(candidates[i] > target){
                break;
            }
            combination.add(candidates[i]);
            Backtrack(candidates, target - candidates[i], i + 1, combination, result);
            combination.remove(combination.size() - 1);

        }
    }
}