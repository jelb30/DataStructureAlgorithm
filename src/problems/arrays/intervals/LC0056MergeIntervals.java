package problems.arrays.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC0056MergeIntervals {

    public static void main(String[] args) {

    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        for(int[] curr : intervals) {
            int[] last = merged.isEmpty() ? null : merged.get(merged.size() -1);

            if(last == null || last[1] < curr[0]) {
                merged.add(curr);
            } else {
                last[1] = Math.max(last[1], curr[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

}
