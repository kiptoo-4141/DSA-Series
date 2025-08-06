class Solution {
    // public void solveSudoku(char[][] board) {
    //     solve(board);
    // }
    // private boolean solve(char[][] board){
    //     for(int row = 0; row < 9; row++){
    //         for(int col = 0; col <= 9; col++){
    //             if(board[row][col] == '.'){
    //                 for(char ch = '1'; ch <= '9'; ch++){
    //                     if(isValid(board, row, col, ch)){
    //                         board[row][col] = ch;
    //                         if(solve(board)){
    //                             return true;
    //                         }
    //                         board[row][col] = '.';
    //                     }
    //                 }
    //                 return false;
    //             }
    //         }
    //     }
    //     return true;
    // }
    // private boolean isValid(char[][] board, int row, int col, char ch){
    //     for(int i = 0; i < 9; i ++){
    //         if(board[0][i] == ch){
    //             return false;
    //         }
    //     }

    //     for(int j = 0; j < 9; j ++){
    //         if(board[j][0] == ch){
    //             return false;
    //         }
    //     }
    //     int rowSqrt = 3;
    //     int colSqrt = 3;
    //     int rowStart = row - row%rowSqrt;
    //     int colStart = col - col%colSqrt;

    //     for(int i = rowStart; i < rowSqrt; i++){
    //         for(int j = colStart; j < colSqrt; j++){

    //             if(board[i][j] == ch){
    //                 return false;
    //             }
    //         }
    //     }

    //     return true;
    // }


    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                // Look for empty cell
                if (board[row][col] == '.') {
                    // Try placing digits 1 to 9
                    for (char num = '1'; num <= '9'; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;

                            // Recur and check if this leads to a solution
                            if (solve(board)) return true;

                            // Backtrack
                            board[row][col] = '.';
                        }
                    }
                    return false; // No number fits here
                }
            }
        }
        return true; // All cells are filled
    }

    private boolean isValid(char[][] board, int row, int col, char num) {
        for (int i = 0; i < 9; i++) {
            // Check row
            if (board[row][i] == num) return false;

            // Check column
            if (board[i][col] == num) return false;

            // Check 3x3 box
            int boxRow = 3 * (row / 3) + i / 3;
            int boxCol = 3 * (col / 3) + i % 3;
            if (board[boxRow][boxCol] == num) return false;
        }
        return true;
    }
}