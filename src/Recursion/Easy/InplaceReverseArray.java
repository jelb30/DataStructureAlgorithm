package Recursion.Easy;

public class InplaceReverseArray {

    private char[] charArr;

    public void Implementation() {

        char[] s = new char[]{'H','a','n','n','a','h'};
        this.charArr = s;

        if(s.length <2){
            return ;
        }
        recursionSwap(0, s.length -1);
        s = charArr;
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }
    }

    public void recursionSwap(int start, int end){
        if(start>=end){
            return;
        }

        char temp = charArr[start];
        charArr[start] = charArr[end];
        charArr[end] = temp;
        recursionSwap(start+1, end-1);

    }

}
