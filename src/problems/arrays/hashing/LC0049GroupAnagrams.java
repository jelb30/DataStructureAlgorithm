package problems.arrays.hashing;

import java.util.*;

public class LC0049GroupAnagrams {

    public static void main(String[] args) {
        String[] arr = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams2(arr).toString());
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        // Map each canonical form -> list of strings sharing that form.
        Map<String, List<String>> groups = new HashMap<>();

        for (String str : strs) {
            // Canonical form = frequency of each letter a-z.
            int[] counts = new int[26];
            for (char c : str.toCharArray()) {
                counts[c - 'a']++;
            }

            StringBuilder keyBuilder = new StringBuilder();
            for (int count : counts) {
                keyBuilder.append(count).append(',');

            }
            String key = keyBuilder.toString();

            groups.computeIfAbsent(key, k -> new ArrayList<>()).add(str);

        }

        return new ArrayList<>(groups.values());
    }

    // Time complexity: O(m * nlogn)
    public static List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            groups.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(groups.values());
    }
}
