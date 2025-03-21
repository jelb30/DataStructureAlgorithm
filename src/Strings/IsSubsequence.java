package Strings;

public class IsSubsequence {

    public void implmentation(String test, String main) {
        boolean validate = isSubSeq(test, main);
        System.out.println(validate);
    }

    public boolean isSubSeq(String test, String main) {
        int mainLen = main.length();
        int testLen = test.length();

        // An empty 'test' string is always a subsequence
        if (testLen < 1) {
            return true;
        }

        int testIndex = 0;  // Pointer to track position in 'test'

        for (int i = 0; i < mainLen; i++) {
            // If characters match, move to the next character in 'test'
            if (test.charAt(testIndex) == main.charAt(i)) {
                testIndex++;

                // If all characters in 'test' are found in order, return true
                if (testIndex >= testLen) {
                    return true;
                }
            }
        }
        // If we finish iterating through 'main' without finding all 'test' characters, return false
        return false;
    }
}
