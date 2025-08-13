class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    
    private boolean solve(char[][] board) {
        // Find the first empty cell
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') {
                    // Try digits 1-9
                    for (char digit = '1'; digit <= '9'; digit++) {
                        if (isValid(board, row, col, digit)) {
                            board[row][col] = digit;
                            
                            // Recursively solve the rest
                            if (solve(board)) {
                                return true;
                            }
                            
                            // Backtrack if solution not found
                            board[row][col] = '.';
                        }
                    }
                    // If no digit works, return false
                    return false;
                }
            }
        }
        // All cells filled successfully
        return true;
    }
    
    private boolean isValid(char[][] board, int row, int col, char digit) {
        // Check row constraint
        for (int c = 0; c < 9; c++) {
            if (board[row][c] == digit) {
                return false;
            }
        }
        
        // Check column constraint
        for (int r = 0; r < 9; r++) {
            if (board[r][col] == digit) {
                return false;
            }
        }
        
        // Check 3x3 box constraint
        int boxRow = (row / 3) * 3;
        int boxCol = (col / 3) * 3;
        for (int r = boxRow; r < boxRow + 3; r++) {
            for (int c = boxCol; c < boxCol + 3; c++) {
                if (board[r][c] == digit) {
                    return false;
                }
            }
        }
        
        return true;
    }
}

// Example usage and test
class SudokuSolverDemo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example puzzle
        char[][] board = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        
        System.out.println("Original puzzle:");
        printBoard(board);
        
        solution.solveSudoku(board);
        
        System.out.println("\nSolved puzzle:");
        printBoard(board);
    }
    
    private static void printBoard(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println("------+-------+------");
            }
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0 && j != 0) {
                    System.out.print("| ");
                }
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
