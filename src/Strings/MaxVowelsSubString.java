package Strings;


import java.util.HashSet;
import java.util.Set;

//LEETCODE PROBLEM NUMBER 1456.
public class MaxVowelsSubString {

    public static void main(String[] args) {
        String s = "abciiidef";
        int count = maxVowelSlidingWindow(s, 3);
        System.out.println(count);
    }


    //WORKS BUT TAKES TIME.
    public static int maxVowels(String s, int k) {

        String vowels = "aeiou";
        int vowelCount = 0;

        int index = 0;
        while (index <= s.length()-k){
            int tempCount = 0;
            for (int i = 0; i < k; i++) {
                char c = s.charAt(index+i);
                if(vowels.contains(String.valueOf(c))) tempCount++;
            }
            vowelCount = Math.max(vowelCount, tempCount);
            index++;
        }

        return vowelCount;
    }

    public static int maxVowelSlidingWindow(String s, int k) {

        String vowels = "aeiou";
        int vowelCount = 0;
        Set<Character> vowelSet = new HashSet<>();
        for (int i = 0; i < vowels.length(); i++) {
            vowelSet.add(vowels.charAt(i));
        }

        for (int i = 0; i < k; i++) {
            if(vowelSet.contains(s.charAt(i))) vowelCount++;

        }

        int tempCount = vowelCount;

        for (int i = k; i < s.length(); i++) {

            if(vowelSet.contains(s.charAt(i))) tempCount++; //ADDING IF NEXT CHARACTER IS VOWEL.
            if(vowelSet.contains(s.charAt(i-k))) tempCount--; //SUBSTRACTING IF FIRST WAS A VOWEL.

            vowelCount = Math.max(vowelCount, tempCount);

        }

        return vowelCount;
    }
}
