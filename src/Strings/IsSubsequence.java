package Strings;

public class IsSubsequence {

    public void implmentation(String test, String main){
        boolean validate = isSubSeq(test, main);
        System.out.println(validate);
    }

    public boolean isSubSeq(String test, String main){
        int mainLen = main.length();
        int testLen = test.length();
        if(testLen<1){
            return true;
        }
        int testIndex = 0;

        for (int i = 0; i < mainLen; i++) {
            if(test.charAt(testIndex) == main.charAt(i)){
                testIndex++;
                if(testIndex>=testLen){
                    return true;
                }
            }
        }
        return false;
    }
}
