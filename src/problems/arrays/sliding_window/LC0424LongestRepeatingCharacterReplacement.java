package problems.arrays.sliding_window;

public class LC0424LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {

    }

    public int characterReplacement(String s, int k) {

        int[] freqArr = new int[26];
        int left = 0;
        int maxCount = 0;
        int maxFreq = 0;

        for (int right = 0; right < s.length(); right++) {

            char c = s.charAt(right);
            freqArr[c-'A']++; //INCREMENTING THE FREQ OF CHARACTER IN THE SLICE.

            maxFreq = Math.max(maxFreq, freqArr[c-'A']);

            /* 'WHY THIS FORMULA?' : if I'm looking at some stretch of the string,
             how many letters would I have to change to make it all the same?
             KEEP THE LETTERS THAT APPEARS MOST, CHANGE OTHERS. */

            while(((right - left + 1) - maxFreq) > k) {
                freqArr[s.charAt(left) -'A']--;
                left++;
            }

            maxCount = Math.max(maxCount, (right - left + 1));
        }

        return maxCount;
    }

}
