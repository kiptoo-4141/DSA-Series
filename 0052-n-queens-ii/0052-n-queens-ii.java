class Solution {
    private int count = 0;
    public int totalNQueens(int n) {
        boolean cols[] = new boolean[n];
        boolean ldiag[] = new boolean[2 * n - 1];
        boolean udiag[] = new boolean[2 * n - 1];

        backtrack(0, n, cols, ldiag, udiag);
        return count;
    }

    private void backtrack(int row, int n, boolean cols[], boolean ldiag[], boolean udiag[]){
        if(row == n){
            count++;
            return;
        }

        for(int col = 0; col < n; col++){
            int d1 = row + col;
            int d2 = row - col + n - 1;

            if(cols[col] || ldiag[d1] || udiag[d2]){
                continue;
            }

            cols[col] = ldiag[d1] = udiag[d2] = true;
            backtrack(row + 1, n, cols, ldiag, udiag);
            cols[col] = ldiag[d1] = udiag[d2] = false;

        }
    }
}