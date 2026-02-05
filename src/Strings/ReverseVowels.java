package Strings;

import java.util.ArrayList;
import java.util.List;

// LEETCODE PROBLEM 345
public class ReverseVowels {

    public static void main(String[] args) {

    }

    public String reverseVowels(String s) {

        StringBuilder vowelz = new StringBuilder();

        for(char c: s.toCharArray()){
            if("aeiouAEIOU".contains(String.valueOf(c))){
                vowelz.append(c);
            }
        }

        System.out.println(vowelz);

        int vowellsIndex = vowelz.length()-1;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if("aeiouAEIOU".contains(String.valueOf(c))){
                c = vowelz.charAt(vowellsIndex);
                vowellsIndex--;
            }
            result.append(c);
        }

        return result.toString();

    }

}


