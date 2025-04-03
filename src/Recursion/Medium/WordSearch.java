package Recursion.Medium;

import java.util.*;

public class WordSearch {

    char[][] board;
    public void implementation(char[][] board, String word){

        Set<Character> matrixSet = new HashSet<>();

        // Add all characters from the 2D array into a set
        for (char[] row : board) {
            for (char c : row) {
                matrixSet.add(c);
            }
        }

        // Check if the set contains all characters from the target string
        for (char c : word.toCharArray()) {
            if (!matrixSet.contains(c)) {
                return;
            }
        }

        this.board = board;
        char firstChar = word.charAt(0);



        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board[i].length; j++) {

                if(board[i][j] == firstChar){

                    List<List<Integer>> visitedList = new ArrayList<>();

                    List<Integer> tempList = new ArrayList<>();
                    tempList.add(i);
                    tempList.add(j);

                    visitedList.add(tempList);
                    if(wordSearch(i, j, word, 1, ""+firstChar, visitedList)){
                        System.out.println("True");
                        return;
                    }
                }
            }
        }

        System.out.println("False");

    }

    public boolean wordSearch(int ithIndex, int jthIndex, String word, int wordIndex, String processed, List<List<Integer>> visitedList){

        if(wordIndex==word.length() && word.equals(processed)){
            return true;
        }

        List<int[]> neighbourFindingList = new ArrayList<>(Arrays.asList(new int[][] {{0,1}, {0,-1}, {1,0}, {-1,0}}));

        for (int[] neighbour: neighbourFindingList){
            int i = ithIndex + neighbour[0];
            int j = jthIndex + neighbour[1];

            int subListSize = this.board[ithIndex].length;
            int listSize = this.board.length;

            List<Integer> tempList = new ArrayList<>();
            tempList.add(i);
            tempList.add(j);

            if(i >=0 && j >= 0 && i < listSize && j < subListSize && word.charAt(wordIndex) == this.board[i][j] && !visitedList.contains(tempList)){
                visitedList.add(tempList);
                if(wordSearch(i, j, word, wordIndex+1, processed+word.charAt(wordIndex), visitedList)){
                    return true;
                }
            }

        }

        if(!visitedList.isEmpty()){
            visitedList.remove(visitedList.size()-1);
        }

        return false;
    }

    // The brut Force method, that popped in my mind, why not try 3^n * N * M Complexity! ><)
    // WE ARE TRAVERSING WHOLE ARRAY FOR EACH CHARACTER INSTEAD OF FINDING NEIGHBOURING!
    public boolean brutForce(char[][] board, String word){
        this.board = board;

        for (int k = 0; k < word.length(); k++) {
            char target = word.charAt(k);
            boolean found = false;

            // Search for the character in the board
            outerLoop:
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == target) {
                        found = true;
                        break outerLoop; // Exit both loops if found
                    }
                }
            }

            if (!found) {
                return false;
            }
        }

        return wordSearchBrutForce(0, 0, word, 0, new ArrayList<>(), "");
    }

    public boolean wordSearchBrutForce(int ithIndex, int jthIndex, String word, int wordIndex, List<List<Integer>> visitedList, String processed) {
        if (wordIndex == word.length() || processed.equals(word)) {
            System.out.println(processed);
            return true;
        }

        char targetChar = word.charAt(wordIndex);

        for (int i = 0; i < this.board.length; i++) {

            for (int j = 0; j < this.board[i].length; j++) {
                if (this.board[i][j] == targetChar) {
                    List<Integer> tempList = new ArrayList<>();
                    tempList.add(i);
                    tempList.add(j);

                    if(visitedList.contains(tempList)){
                        continue;
                    }

                    if (wordIndex == 0) {
                        visitedList.add(tempList);
                        if(wordSearchBrutForce(i, j, word, wordIndex + 1, visitedList, processed+targetChar)) return true;
                    }

                    if (j == (jthIndex + 1) && i == ithIndex) {
                        visitedList.add(tempList);
                        if(wordSearchBrutForce(i, j, word, wordIndex + 1, visitedList, processed+targetChar)) return true;
                    }
                    if (j == (jthIndex - 1) && i == ithIndex) {
                        visitedList.add(tempList);
                        if(wordSearchBrutForce(i, j, word, wordIndex + 1, visitedList, processed+targetChar)) return true;
                    }

                    if (i == (ithIndex + 1) && j == jthIndex) {
                        visitedList.add(tempList);
                        if(wordSearchBrutForce(i, j, word, wordIndex + 1, visitedList, processed+targetChar)) return true;
                    }

                    if (i == (ithIndex - 1) && j == jthIndex) {
                        visitedList.add(tempList);
                        if(wordSearchBrutForce(i, j, word, wordIndex + 1, visitedList, processed+targetChar)) return true;
                    }

                }

            }

        }
        if(!visitedList.isEmpty()){
            visitedList.remove(visitedList.size()-1);
        }
        return false;

    }

}


