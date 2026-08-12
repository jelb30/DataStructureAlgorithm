package problems.arrays.sliding_window;

import java.util.HashMap;
import java.util.HashSet;

public class LC0003LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {

        String str = "abba";
        int count = lengthOfLongestSubstring(str);
        System.out.println(count);
    }

    public static int lengthOfLongestSubstring(String s) {

        HashMap<Character, Integer> lastSeen = new HashMap<>();
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            char c = s.charAt(right);
            if(lastSeen.containsKey(c) && lastSeen.get(c) >= left) {
                left = lastSeen.get(c) + 1;
            }

            lastSeen.put(c, right); // UPDATING THE LAST SEEN INDEX FOR BETTER LEFT POINTER MOVEMENT!
            maxLength = Math.max(maxLength, right - left +1);

        }
        return maxLength;
    }
}
