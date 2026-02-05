package Strings;

public class GreatestCommonDevisorString {

    public static void main(String[] args) {
        System.out.println(gcdOfStrings("LEET", "LEET"));
    }

    public static String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        int gcdLength = gcd(str1.length(), str2.length());
        System.out.println(gcdLength);


        return str1.substring(0, gcdLength);
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
