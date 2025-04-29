package Strings;
import java.util.ArrayList;
import java.util.List;

public class SubstringPalindrome {


    List<String> substrings;

    public String longestPalindrome(String s) {
        this.substrings = new ArrayList<>();

        generateSustring(s);

        int maxLength=0;
        String largestSubseq = "";
        for (String substring: this.substrings){
            String rev = "";
            for (int i = substring.length()-1; i >= 0 ; i--) {
                rev = rev + substring.charAt(i);
            }
            if(substring.compareTo(rev)==0){
                if( substring.length() > maxLength){
                    largestSubseq = substring;
                    maxLength = substring.length();
                }
            }
        }

        System.out.println(largestSubseq);
        return largestSubseq;
    }

    public void generateSustring(String str){


        for (int start = 0; start < str.length(); start++) {
            for (int end= start+1; end <= str.length(); end++) {
                this.substrings.add(str.substring(start, end));
            }
        }

    }
}
