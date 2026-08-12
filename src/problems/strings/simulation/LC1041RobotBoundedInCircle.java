package problems.strings.simulation;

public class LC1041RobotBoundedInCircle {

    public static void main(String[] args) {

    }

    public static boolean isRobotBounded(String instructions) {

        int x = 0;
        int y = 0;
        int[][] dirs = {{0,1}, {1,0}, {0, -1}, {-1, 0}};
        int d = 0;

        for (int i = 0; i < instructions.length(); i++) {
            char instruction = instructions.charAt(i);
            if(instruction == 'G') {
                x += dirs[d][0];
                y += dirs[d][1];
            } else if(instruction == 'L') {
                d--;
                if(d < 0) {
                    d=3;
                }
            } else if(instruction == 'R') {
                d++;
                if(d > dirs.length-1) {
                    d = 0;
                }
            }
        }

        if((x == 0 && y == 0) ||  d != 0) {
            return true;
        }
        return false;
    }
}
