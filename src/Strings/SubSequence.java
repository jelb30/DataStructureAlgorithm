package Strings;

import java.util.ArrayList;
import java.util.List;

public class SubSequence {

    public void implementation(String str){

        List<String> subsetList = subseqArr("", str);

        System.out.println(subsetList.size());
        for (String s: subsetList){
            System.out.println(s);
        }
    }

    public void subseq(String processed, String unprocessed){

        // Recurssion is used here.
        // We are taking one empty string and in that adding one character and removing same from main string
        // After again we are adding next character to the substriung and removing that from the main string!s

        if(unprocessed.isEmpty()){
            System.out.println(processed);
            return;
        }

        char firstChar = unprocessed.charAt(0);

        subseq(processed+firstChar, unprocessed.substring(1));
        subseq(processed, unprocessed.substring(1));
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

