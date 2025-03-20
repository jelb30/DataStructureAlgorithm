package Strings;

import javax.swing.*;

public class Permutation {

    public void implemetation(String str){
        permutation("", str);
    }

    public void permutation(String processed, String unprocessed){

        if(unprocessed.isEmpty()){
            System.out.println(processed);
            return;
        }
        
        char firstChar = unprocessed.charAt(0);

        for (int i = 0; i <= processed.length(); i++) {
            String prefix = processed.substring(0, i);
            String suffix = processed.substring(i, processed.length());
            permutation(prefix + firstChar + suffix, unprocessed.substring(1));
        }

    }
}
