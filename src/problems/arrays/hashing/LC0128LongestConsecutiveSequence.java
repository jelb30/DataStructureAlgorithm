package problems.arrays.hashing;

import java.util.HashSet;
import java.util.Set;

public class LC0128LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {

        HashSet<Integer> set = new HashSet<>();
        for(int num:nums) {
            set.add(num);
        }

        int maxConsec = 0;
        for(int num: set) {
            if(!set.contains(num-1)) {
                int currStrek = 1;
                int currentNum = num;

                while(set.contains(num+1)) {
                    currentNum +=1;
                    currStrek += 1;
                }

                maxConsec = Math.max(maxConsec, currStrek);
            }
        }
        return maxConsec;
    }
}
