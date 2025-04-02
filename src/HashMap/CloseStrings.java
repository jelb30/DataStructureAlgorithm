package HashMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// LEETCODE PROBLEM NUMBER 1657.
public class CloseStrings {

    public void implementation(String word1, String word2){
        System.out.println("Provided 2 Strings are close: "+closeStrings(word1, word2));
    }

    private boolean closeStrings(String word1, String word2){

        if(word1.length() != word2.length()){
            return false;
        }

        Map<Character, Integer> freqMap1 = getFrequencyMap(word1);
        Map<Character, Integer> freqMap2 = getFrequencyMap(word2);

        // If they have different characters, return false
        if (!freqMap1.keySet().equals(freqMap2.keySet())) {
            return false;
        }

        ArrayList<Integer> freqList1 = new ArrayList<>(freqMap1.values());
        ArrayList<Integer> freqList2 = new ArrayList<>(freqMap2.values());

        //Sort and compare frequency distributions
        Collections.sort(freqList1);
        Collections.sort(freqList2);

        return freqList1.equals(freqList2);

    }

    private static Map<Character, Integer> getFrequencyMap(String str) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : str.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        return freqMap;
    }

}
