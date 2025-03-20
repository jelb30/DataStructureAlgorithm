package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayPermutations {

    List<List<Integer>> listInteger;

    public void implementation(int[] nums){
        this.listInteger = new ArrayList<>();
        permutation(new ArrayList<>(), nums);
    }

    public void permutation(List<Integer> processed,int[] unprocessed){

        if(unprocessed.length==0){
            this.listInteger.add(processed);
            return;
        }

        int firstInt = unprocessed[0];

        for (int i = 0; i <=processed.size(); i++) {
            List<Integer> prefixList = new ArrayList<>(processed.subList(0, i));
            prefixList.add(firstInt);
            prefixList.addAll(processed.subList(i, processed.size()));
            permutation(prefixList, Arrays.copyOfRange(unprocessed, 1, unprocessed.length));
        }

    }
}
