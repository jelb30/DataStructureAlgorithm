package Strings;

//LEETCODE 1768
public class MergeStringAlternate {

    public static void main(String[] args) {
        String word1= "abd";
        String word2 = "pqrs";

        mergeAlternately(word1, word2);
    }

    public static String mergeAlternately(String word1, String word2) {

        StringBuilder merged = new StringBuilder();

        int maxLen = Math.max(word1.length(), word2.length());

        for (int i = 0; i < maxLen; i++) {
            if (i < word1.length()){
                merged.append(word1.charAt(i));
            }
            if (i < word2.length()){
                merged.append(word2.charAt(i));
            }
        }

        System.out.println(merged);
        return merged.toString();
    }
}
