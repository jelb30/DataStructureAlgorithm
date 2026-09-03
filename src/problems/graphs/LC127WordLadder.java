package problems.graphs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;

public class LC127WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        HashSet<String> set = new HashSet<>(wordList);
        Deque<String> q = new ArrayDeque<>();

        if(!set.contains(endWord)) return 0;
        q.offer(beginWord);
        set.remove(beginWord);

        int level = 1;

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                String word = q.poll();
                if (word.equals(endWord)) return level;
                char[] arr = word.toCharArray();
                for(int pos = 0; pos < arr.length; pos++) {
                    char original = arr[pos];
                    for(char c='a'; c <= 'z'; c++) {
                        arr[pos] = c;
                        String next = new String(arr);
                        if(set.contains(next)) {
                            q.offer(next);
                            set.remove(next);
                        }
                    }
                    arr[pos] = original;
                }
            }
            level++;
        }
        return 0;
    }
}
