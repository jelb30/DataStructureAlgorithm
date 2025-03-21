package Strings;

public class Permutation {

    public void implemetation(String str) {
        permutation("", str);
    }

    public void permutation(String processed, String unprocessed) {

        // Base case: If unprocessed string is empty, print the permutation
        if (unprocessed.isEmpty()) {
            System.out.println(processed);
            return;
        }

        char firstChar = unprocessed.charAt(0); // Take the first character of unprocessed

        // Insert 'firstChar' at every possible position in 'processed'
        for (int i = 0; i <= processed.length(); i++) {
            String prefix = processed.substring(0, i); // Part before insertion
            String suffix = processed.substring(i);    // Part after insertion

            // Recursive call with updated 'processed' and remaining 'unprocessed'
            permutation(prefix + firstChar + suffix, unprocessed.substring(1));
        }
    }
}
