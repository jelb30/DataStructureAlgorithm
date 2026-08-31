package problems.design;
public class DesignAddSearchWords {

    public static class TrieNode {
        TrieNode[] childrens = new TrieNode[26];
        boolean isEndOfWord = false;
    }

    private final TrieNode root;


    public DesignAddSearchWords() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for(char c: word.toCharArray()) {
            int index = c - 'a';
            if(node.childrens[index] == null) {
                node.childrens[index] = new TrieNode();
            }
            node = node.childrens[index];
        }
        node.isEndOfWord = true;
    }

    public boolean search(String word) {
        return dfs(word , 0, root);
    }

    public boolean dfs(String word, int index, TrieNode node) {
        if(index == word.length()) {
            return node.isEndOfWord;
        }

        char c = word.charAt(index);
        if ( c == '.') {
            for(TrieNode child: node.childrens) {
                if(child != null && dfs(word, index+1, child)) {
                    return true;
                }
            }
            return false;
        } else {
            int childIndex = c - 'a';
            if (node.childrens[childIndex] != null) {
                node = node.childrens[childIndex];
            } else {
                return false;
            }
        }

        return dfs(word, index+1, node);
    }

}
