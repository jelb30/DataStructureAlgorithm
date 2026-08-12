package problems.arrays.intervals;

import java.util.Arrays;

public class LC0253MeetingRoomsII {

    public static void main(String[] args) {

    }

    public static int minMeetingRooms(int[][] intervals) {
        if(intervals.length == 0) return 0;
        if(intervals.length == 1) return 1;

        int size = intervals.length;

        int[] starts = new int[size];
        int[] ends = new int[size];

        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        int s = 0;
        int e = 0;
        int count = 0;
        int maxMeetingRooms = 0;

        while(s < size) {
            if(starts[s] < ends[e]) {
                s++;
                count++;
            } else {
                e++;
                count --;
            }
            maxMeetingRooms = Math.max(maxMeetingRooms, count);
        }

        return maxMeetingRooms;
    }
}
