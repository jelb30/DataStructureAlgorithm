package problems.design;
import java.util.zip.ZipInputStream;

public class LC0014LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int counts = 0;
    }

    public static String longestCommonPrefix(String[] strs) {

        if(strs.length == 0) {
            return "";
        }

        TrieNode root = new TrieNode();
        for(String str: strs) {
            buildTrie(str, root);
        }

        StringBuilder stringBuilder = new StringBuilder("");

        String first = strs[0];
        for(char c: first.toCharArray()) {
            int index = c - 'a';
            System.out.println(c +" : " + index);
            if(root.children[index] == null) {
                break;
            }
            if(root.children[index].counts == strs.length) {
                stringBuilder.append(c);
                root = root.children[index];
            } else {
                break;
            }
        }
        return stringBuilder.toString();
    }

    public static void buildTrie(String str, TrieNode root) {
        for(char c: str.toCharArray()) {
            int index = c - 'a';
            if(root.children[index] == null) {
                root.children[index] = new TrieNode();
            }
            root = root.children[index];
            root.counts += 1;
        }
    }
}
