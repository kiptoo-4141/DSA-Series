class Solution {
    private final long MOD = 1_000_000_007;
    public int[] productQueries(int n, int[][] queries) {
        List<Long> powers = buildPowersArray(n); 

        int[] answers = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            int left = queries[i][0];
            int right = queries[i][1];
            long product = 1;

            for(int j = left; j <= right; j++){
                product = (product*powers.get(j))%MOD;
            }
            answers[i] = (int)product;
        }
        return answers;
    }

    private List<Long> buildPowersArray(int n) {
        List<Long> powers = new ArrayList<>();
        long pow = 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                powers.add(pow);
            }
            pow <<= 1;
            n >>= 1;
        }
        return powers; // already in ascending order
    }
}