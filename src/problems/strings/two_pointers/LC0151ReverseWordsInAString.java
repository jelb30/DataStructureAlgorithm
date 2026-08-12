package problems.strings.two_pointers;

// LEETCODE PROBLEM NUMBER 151.

public class LC0151ReverseWordsInAString {

    public static void main(String[] args) {
        reverseWords(" the sky    is blue");
    }

    public static String reverseWords(String s) {

        String finalString = "";

        String tempStr = "";
        boolean firstSpace = true;

        for (int i = 0; i < s.length(); i++) {

            if(s.charAt(i)==' '){
                if(firstSpace){
                    finalString = tempStr + " " + finalString;
                    tempStr="";
                    firstSpace = false;
                }
                continue;
            }

            tempStr+=s.charAt(i);
            if(i == s.length()-1){
                finalString = tempStr+ " "+ finalString;
            }
            firstSpace = true;

        }
        System.out.println(finalString.trim());
        return finalString;
    }
}
