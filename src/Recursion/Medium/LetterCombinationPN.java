package Recursion.Medium;

import java.util.*;

public class LetterCombinationPN {

    Map<Integer, String> keypadMap;
    List<String> combinations;

    public void implementation(String digits){
        this.keypadMap = new HashMap<>();

        keypadMap.put(2, "abc");
        keypadMap.put(3, "def");
        keypadMap.put(4, "ghi");
        keypadMap.put(5, "jkl");
        keypadMap.put(6, "mno");
        keypadMap.put(7, "pqrs");
        keypadMap.put(8, "tuv");
        keypadMap.put(9, "wxyz");


        //System.out.println(combinations("234"));

        //List<String> letterCombinations = combinationsString(digits);
        //System.out.println(letterCombinations);
        //System.out.println("Number of combinations can be made: "+letterCombinations.size());

        this.combinations = new ArrayList<>();
        combinationsRecursion("", digits);
        System.out.println(this.combinations);
        System.out.println("Number of combinations can be made: "+this.combinations.size());

    }

    public  List<List<String>> combinations(String digits){

        List<List<String>> finalList = new ArrayList<>();
        if(digits.isEmpty()){
            return finalList;
        }

        int firstDigit = Integer.parseInt(String.valueOf(digits.charAt(0)));
        String firstMapping = this.keypadMap.get(firstDigit);

        for (int i = 0; i < firstMapping.length(); i++) {
            List<String> singleCharList = new ArrayList<>();
            singleCharList.add(String.valueOf(firstMapping.charAt(i))); // Convert char to String
            finalList.add(singleCharList);
        }

        int arraycount =0;
        for(char c: digits.substring(1).toCharArray()){
            int charInt = Integer.parseInt(String.valueOf(c));
            String mappedStr = this.keypadMap.get(charInt);

            int finalListSize = finalList.size();
            int temp =0;

            for (int i = 0; i < mappedStr.length(); i++) {
                for (int j= arraycount; j < finalListSize; j++) {
                    List<String> tempList = new ArrayList<>(finalList.get(j));
                    tempList.add(String.valueOf(mappedStr.charAt(i)));
                    finalList.add(tempList);
                    temp++;
                }
            }
            arraycount= finalList.size()-temp;
        }

        Iterator<List<String>> iterator = finalList.iterator();
        while (iterator.hasNext()) {
            List<String> sublist = iterator.next();
            if (sublist.size() < digits.length()) {
                iterator.remove(); // Remove lists smaller than minSize
            }
        }
        return finalList;

    }

    // ACTUAL SOLUTION TO THE PROBLEM.
    public  List<String> combinationsString(String digits){

        List<String> finalList = new ArrayList<>();
        if(digits.isEmpty()){
            return finalList;
        }


        int firstDigit = Integer.parseInt(String.valueOf(digits.charAt(0)));
        String firstMapping = this.keypadMap.get(firstDigit);

        // TAKE THE FIRST DIGIT AND ADD THE LETTERS INDIVIDUALLY TO THE LIST LIKE 'A','B', 'C'.
        for (int i = 0; i < firstMapping.length(); i++) {
            finalList.add(String.valueOf(firstMapping.charAt(i)));
        }

        // ITERATE THROUGHY ALL THE GIVEN DIGIT FROM INDEX 1!
        // ADD ALL THE LETTERS FROM THE DIGITS MAPPING AND ADD THEM WITH LIST MEMBERS SEPERATELY AND ADD IN THE LIST!
        int arraycount =0;
        for(char c: digits.substring(1).toCharArray()){
            int charInt = Integer.parseInt(String.valueOf(c));
            String mappedStr = this.keypadMap.get(charInt); // TAKING THE MAPPED STRING!

            int finalListSize = finalList.size();
            int temp =0;

            for (int i = 0; i < mappedStr.length(); i++) { // FOR EVERY CHARACTER IN STRING!
                for (int j= arraycount; j < finalListSize; j++) { // ADDING EACH CHARACTER TO THE LISTS!
                    String tempStr = finalList.get(j);
                    tempStr = tempStr + String.valueOf(mappedStr.charAt(i));
                    temp++;
                    finalList.add(tempStr);
                }
            }

            arraycount= finalList.size()-temp;
        }

        Iterator<String> iterator = finalList.iterator();
        while (iterator.hasNext()) {
            String substr = iterator.next();
            if (substr.length() < digits.length()) {
                iterator.remove(); // Remove lists smaller than minSize
            }
        }
        return finalList;

    }

    // RECURSIVE BUT NOT THAT OPTIMAL!
    public void combinationsRecursion(String processed, String unprocessed){


        if(unprocessed.isEmpty()){
            this.combinations.add(processed);
            return;
        }

        int index = Integer.parseInt(String.valueOf(unprocessed.charAt(0)));
        String tempStr = this.keypadMap.get(index);

        for (int i = 0; i < tempStr.length(); i++) {
            combinationsRecursion(processed+tempStr.charAt(i), unprocessed.substring(1));
        }
    }
}
