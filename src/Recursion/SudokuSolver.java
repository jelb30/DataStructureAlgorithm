package Recursion;

public class SudokuSolver {

    public void implementation(char[][] board){

        System.out.println(sudokuSolverCharArr(board));
        printBoardCharArr(board);

    }

    // EVERY METHOD IS DESIGN TO SOLVE THE SUDKOU FOR INT ARRAY INPUT!
    private boolean SolveSudoku(int[][] board){

        boolean isSolved = true;
        int row = -1;
        int col = -1;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if( board[i][j]==0){
                    isSolved = false;
                    row = i;
                    col = j;
                    break;
                }
            }
            if(!isSolved) break;
        }

        if(isSolved){
            // if its not converted false then full arrayy is populated with non-zero! and it is solved!
            //print the board function!
            printBoard(board);
            return true;
        }

        for (int num = 1; num <= board.length; num++) {
            if(isSafe(board, row, col, num)){
                board[row][col] = num;
                if(SolveSudoku(board)) return true;
                else board[row][col] = 0;

            }
        }
        return false;

    }

    private void printBoard(int[][] board) {
        for(int[] subArr: board){
            for(int num: subArr){
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }

    private boolean isSafe(int[][] board, int row, int col, int num) {

        if(!isValid(board, row, col)){
            return false;
        }

        for (int i = 0; i < board.length; i++) {
            if(board[row][i] == num)
                return false;
        }

        for( int[] subArr: board){
            if(subArr[col] == num){
                return false;
            }
        }

        int rowStart = row - row % 3;
        int colStart = col - col % 3;

        for (int i = rowStart; i < rowStart+3; i++) {
            for (int j = colStart; j < colStart+3; j++) {
                if(board[i][j]==num){
                    return false;
                }
            }
        }

        return true;

    }

    private boolean isValid(int[][] board, int row, int col) {
        if(row>=0 && row< board.length && col>=0 && col<board.length){
            return true;
        }
        return false;
    }

    private boolean sudokuSolverCharArr(char[][] board){
        
        for (int row = 0; row < 9; row++) {
            
            for (int col = 0; col < 9; col++) {
                
                if (board[row][col] == '.') {
                    
                    for (char num = '1'; num <= '9'; num++) {
                        
                        if (isSafeCharArr(board, row, col, num)) {
                            
                            board[row][col] = num;
                            if (sudokuSolverCharArr(board)) {
                                return true;
                            }
                            board[row][col] = '.'; // Backtracking
                        }
                    }
                    return false; // No valid number found, trigger backtracking
                }
            }
        }
        return true; // Solved
    }

    private boolean isSafeCharArr(char[][] board, int row, int col, char num) {

        if(!isValidCharArr(board, row, col)){
            return false;
        }

        for (int i = 0; i < board.length; i++) {
            if(board[row][i] == num)
                return false;
        }

        for( char[] subArr: board){
            if(subArr[col] == num){
                return false;
            }
        }

        int rowStart = row - row % 3;
        int colStart = col - col % 3;

        for (int i = rowStart; i < rowStart+3; i++) {
            for (int j = colStart; j < colStart+3; j++) {
                if(board[i][j]==num){
                    return false;
                }
            }
        }

        return true;

    }

    private boolean isValidCharArr(char[][] board, int row, int col) {
        if(row>=0 && row< board.length && col>=0 && col<board.length){
            return true;
        }
        return false;
    }

    private void printBoardCharArr(char[][] board) {
        for (char[] row : board) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }


}
