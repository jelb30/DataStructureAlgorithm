package Arrays;

import java.util.ArrayList;
import java.util.List;

public class Subset {

    public void Implementation() {
        List<List<Integer>> subsetList = subset(new int[]{0}); // Generate subsets for {0}

        // Print all subsets
        for (List list : subsetList) {
            System.out.println(list);
        }
    }

    public List<List<Integer>> subset(int[] nums) {
        List<List<Integer>> outerList = new ArrayList<>();
        outerList.add(new ArrayList<>()); // Start with an empty subset

        // Iterate through each number in the input array
        for (int num : nums) {
            int n = outerList.size(); // Get the current number of subsets

            // Add the current number to each existing subset to form new subsets
            for (int i = 0; i < n; i++) {
                List<Integer> innerList = new ArrayList<>(outerList.get(i)); // Copy existing subset
                innerList.add(num); // Add new element
                outerList.add(innerList); // Add the newly created subset to the list
            }
        }

        return outerList; // Return the complete list of subsets
    }
}
