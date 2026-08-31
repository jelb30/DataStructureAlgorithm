package problems.design;
public class TaskScheduler {

    public static void main(String[] args) {

    }

    public static int leastInterval(char[] tasks, int n) {

        char[] freqArr = new char[26];
        for(char C: tasks) {
            freqArr[C - 'A']++;
        }

        int maxFreq = 0;
        for(int count : freqArr) {
            maxFreq = Math.max(maxFreq, count);
        }

        int maxCounts = 0;
        for(int count: freqArr) {
            if (count == maxFreq) maxCounts++;
        }

        int formula = (maxFreq - 1) * (n+1) + maxCounts;
        return Math.max(formula, tasks.length);
    }


}
