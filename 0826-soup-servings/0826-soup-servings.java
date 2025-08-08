class Solution {
    private double[][] dp;
    public double soupServings(int n) {
        if(n > 4800){
            return 1.0;
        }
        
        int N = (n + 24) / 25; 
        dp = new double[N + 1][N + 1];
        for (double[] row : dp) Arrays.fill(row, -1.0);
        return dfs(N, N);
    }

     private double dfs(int a, int b) {
        if (a <= 0 && b <= 0) return 0.5;
        if (a <= 0) return 1.0;
        if (b <= 0) return 0.0;

        if (dp[a][b] >= 0) return dp[a][b];

        double res = 0.25 * (
                dfs(a - 4, b) +
                dfs(a - 3, b - 1) +
                dfs(a - 2, b - 2) +
                dfs(a - 1, b - 3)
        );

        dp[a][b] = res;
        return res;
    }
}