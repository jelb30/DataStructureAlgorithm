package problems.design.trie;

public class ImplementTrie {

    private class TrieNode   {
        TrieNode[] children = new TrieNode[26];
        boolean isWordEnd = false;
    }

    private final TrieNode root;

    public ImplementTrie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for(char c : word.toCharArray()) {
            int index = c - 'a';

            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isWordEnd = true;
    }

    public boolean search(String word) {
        TrieNode node = helper(word);
        if(node == null) return false;
        else return node.isWordEnd ? true : false;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = helper(prefix);
        if(node == null) return false;
        else return true;
    }

    private TrieNode helper(String word) {
        TrieNode node = root;
        for(char c : word.toCharArray()) {
            int index = c - 'a';
            if(node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }
}
