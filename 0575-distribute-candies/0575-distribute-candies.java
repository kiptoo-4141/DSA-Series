class Solution {
    public int distributeCandies(int[] candyType) {
        int n = candyType.length;
        Set<Integer> UniqueCandy = new HashSet<>();

        for(int candy : candyType){
            UniqueCandy.add(candy);
        }

        int eatCandy = candyType.length / 2;
        return Math.min(eatCandy, UniqueCandy.size());
    }
}