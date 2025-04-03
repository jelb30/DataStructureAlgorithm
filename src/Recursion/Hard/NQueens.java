package Recursion.Hard;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

    public void implementation(int n){

        boolean[][] board = new boolean[n][n];
        List<List<String>> finalList = placeQueensList(board, 0);

        for(List<String> list: finalList){
            System.out.println(list);
        }

    }

    public boolean placeQueens(boolean[][] board, int row){

        // base condition, we are running this recursion on the row increments
        if(row == board.length){

            for (boolean[] arr: board){
                for (boolean value: arr){
                    if(value) System.out.print("Q ");
                    else System.out.print("X ");
                }
                System.out.println();
            }
            System.out.println();
            return true;
        }

        for (int col = 0; col < board[row].length; col++) {
            if(isSafe(board, row, col)){
                board[row][col] = true;
                if(placeQueens(board, row+1)) return true;
                board[row][col] = false; // backtracking.
            }
        }

        return false;
    }


    // Algorithm for Queens Safety.
    public boolean isSafe(boolean[][] board, int row, int col){

        // Checking Same in same columns above this one!
        for (int i = 0; i < row; i++) {

            if(board[i][col]) return false;

        }

        // Checking  Left Diagonal
        int minLeftDia = Math.min(row, col);

        for (int i = 1; i <= minLeftDia; i++) {

            if(board[row-i][col-i]) return false;

        }

        // Checking Right Diagonal
        int maxRightDia = Math.min(row, board.length-1-col);

        for (int i = 1; i <= maxRightDia; i++) {

            if( board[row-i][col+i]) return false;

        }

        return true;
    }

    // RETURNING ALL POSSIBLE SOLUTIONS IN LIST.
    public List<List<String>> placeQueensList(boolean[][] board, int row){

        // base condition, we are running this recursion on the row increments
        if(row == board.length){

            return getLists(board);
        }

        List<List<String>> finalList = new ArrayList<>();

        for (int col = 0; col < board[row].length; col++) {
            if(isSafe(board, row, col)){
                board[row][col] = true;
                finalList.addAll(placeQueensList(board, row+1));
                board[row][col] = false; // backtracking.
            }
        }

        return finalList;
    }

    private static List<List<String>> getLists(boolean[][] board) {
        List<List<String>> outterList = new ArrayList<>();
        List<String> tempList = new ArrayList<>();

        for (boolean[] arr: board){
            String tempStr = "";


            for (boolean value: arr){

                if(value){
                    tempStr+="Q";
                }
                else{
                    tempStr+=".";
                }
            }
            tempList.add(tempStr);
        }
        outterList.add(tempList);
        return outterList;
    }
}
