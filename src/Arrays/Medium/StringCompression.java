package Arrays.Medium;


//LEETCODE PROBLEM NUMBER 443.

public class StringCompression {

    public static void main(String[] args) {
        char[] chars = new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        int len = compress(chars);
        System.out.println(len);
    }

    public static int compress(char[] chars) {

        int duplicateCount = 1;
        StringBuilder sb = new StringBuilder();
        sb.append(chars[0]);

        for (int i = 1; i < chars.length; i++) {
            if(chars[i]==chars[i-1]){
                duplicateCount++;
                continue;
            }

            if(duplicateCount>1) {
                sb.append(String.valueOf(duplicateCount));
                duplicateCount=1;
            }

            sb.append(chars[i]);
        }

        if(duplicateCount>1) sb.append(duplicateCount);

        for (int i = 0; i < sb.length(); i++) {
            chars[i] = sb.charAt(i);
        }

        for (int i = sb.length(); i < chars.length; i++) {
            chars[i] = 0;
        }


        System.out.println(sb.toString());
        return sb.length();

    }
}
