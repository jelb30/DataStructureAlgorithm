package Arrays.Easy;

public class FindHighestAltitude {

    public static void main(String[] args) {

    }

    public int largestAltitude(int[] gain) {
        int[] altitude = new int[gain.length+1];

        int maxAltitude = 0;

        for (int i = 1; i < altitude.length; i++) {
            altitude[i]+= altitude[i-1]+gain[i-1];
            if (maxAltitude<altitude[i]) maxAltitude=altitude[i];
        }

        return maxAltitude;
    }

}
