package Strings;

import java.util.ArrayList;
import java.util.List;

public class SubsetPalindrome {


    public void implementation(String str){

        SubSequence subSequence = new SubSequence();
        List<String> subsetList = subSequence.subseqArr("", str);

        int maxLength=0;
        String largestSubseq = "";
        for (String substring: subsetList){
            String rev = "";
            for (int i = substring.length()-1; i >= 0 ; i--) {
                rev = rev + substring.charAt(i);
            }
            if(substring.compareTo(rev)==0){
                System.out.println("Substring Palindrome: "+substring);
                if( substring.length() > maxLength){
                    largestSubseq = substring;
                    maxLength = substring.length();
                }
            }
        }

        System.out.println(largestSubseq);
    }

    public List<String> subseqArr(String processed, String unprocessed){

        // Recurssion is used here.
        // We are taking one empty string and in that adding one character and removing same from main string
        // After again we are adding next character to the substriung and removing that from the main string!s

        if(unprocessed.isEmpty()){
            List<String> strList = new ArrayList<>();
            strList.add(processed);
            return strList;
        }

        char firstChar = unprocessed.charAt(0);

        List<String> left = subseqArr(processed+firstChar, unprocessed.substring(1));
        List<String> right = subseqArr(processed, unprocessed.substring(1));

        left.addAll(right);
        return left;
    }
}
