package Arrays.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayPermutations {

    List<List<Integer>> listInteger; // Stores all generated permutations

    public void implementation(int[] nums) {
        this.listInteger = new ArrayList<>();
        permutation(new ArrayList<>(), nums);
    }

    public void permutation(List<Integer> processed, int[] unprocessed) {

        // Base case: If there are no more numbers to process, store the permutation
        if (unprocessed.length == 0) {
            this.listInteger.add(processed);
            return;
        }

        int firstInt = unprocessed[0]; // First element to be inserted in 'processed'

        // Insert 'firstInt' at every position in 'processed' to generate permutations
        for (int i = 0; i <= processed.size(); i++) {
            List<Integer> prefixList = new ArrayList<>(processed.subList(0, i)); // Part before insertion
            prefixList.add(firstInt); // Insert the current element
            prefixList.addAll(processed.subList(i, processed.size())); // Add remaining elements

            // Recursive call with the updated 'processed' and the remaining 'unprocessed'
            permutation(prefixList, Arrays.copyOfRange(unprocessed, 1, unprocessed.length));
        }
    }
}
