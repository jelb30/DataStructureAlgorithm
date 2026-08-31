package problems.design;
import problems.trees.LC0111MinimumDepthOfBinaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchSuggestionsSystem {

    public static class TrieNode {
        TrieNode[] childrens = new TrieNode[26];
        List<String> suggestions = new ArrayList<>();
        boolean isWordEnd = false;
    }

    private final TrieNode root = new TrieNode();

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> results = new ArrayList<>();
        // SORTING WILL KEEP THE LEXICOGRAPHY ORDER IN HERE!
        Arrays.sort(products);

        // BUILDING TRIES FOR EACH WORDS.
        for(String word: products) {
            buildTrie(word);
        }

        /*TRAVERSING THE PREFIX OF THE SEARCH WORD AND
        ATTACHING ITS SUGGESTION LIST OF EACH PREFIX CHARACTER
        TO RESULTS. BETTER QUERYING.
        */
        TrieNode node = root;
        for(char c: searchWord.toCharArray()) {
            int index = c - 'a';
            if(node != null && node.childrens[index] != null) {
                node = node.childrens[index];
                results.add(node.suggestions);
            } else {
                node = null;
                results.add(new ArrayList<>());
            }
        }
        return results;
    }

    public void buildTrie(String word) {
        TrieNode node = root;
        for(char c : word.toCharArray()) {
            int index = c - 'a';
            if(node.childrens[index] == null) {
                node.childrens[index] = new TrieNode();
            }
            node = node.childrens[index];

            // ADDIND THE SORTED WORDS IN THE PREFIXES FOR BETTER QUERYING.
            if(node.suggestions.size() < 3) {
                node.suggestions.add(word);
            }
        }
        node.isWordEnd = true;
    }
}
