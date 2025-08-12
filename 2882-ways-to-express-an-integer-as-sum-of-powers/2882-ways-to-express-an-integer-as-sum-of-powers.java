class Solution {
    private long[][] dp;
    private final int MOD = 1_000_000_007;

    public int numberOfWays(int n, int x) {
        int maxBase = 1;
        while (Math.pow(maxBase + 1, x) <= n) {
            maxBase++;
        }

        dp = new long[n+1][maxBase+2];
        for (long[] row : dp){
            Arrays.fill(row, -1);
        }

        return (int) solve(n, 1, x, maxBase);
    }
    private long solve(int remaining, int curr, int x, int maxBase){
        if(remaining == 0){
            return 1;
        }

        if(remaining < 0 || curr > maxBase){
            return 0;
        }

        if(dp[remaining][curr] != -1){
            return dp[remaining][curr];
        }

        long power = (long)Math.pow(curr, x);
        long take = 0;
        if(power <= remaining){
            take = solve(remaining - (int)power, curr + 1, x, maxBase) % MOD;
        }
        

        long skip = solve(remaining, curr + 1, x, maxBase) % MOD;

        return dp[remaining][curr] = (take + skip) % MOD;
    }
}