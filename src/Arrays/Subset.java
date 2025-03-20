package Arrays;

import java.util.ArrayList;
import java.util.List;

public class Subset {

    public void Implementation(){
        List<List<Integer>> subsetList = subset(new int[]{0});
        for (List list: subsetList){
            System.out.println(list);
        }
    }

    public List<List<Integer>> subset(int[] nums){
        List<List<Integer>> outerList = new ArrayList<>();
        outerList.add(new ArrayList<>());

        for (int num: nums){
            int n = outerList.size();
            for (int i = 0; i < n; i++) {
                List<Integer> innerList= new ArrayList<>(outerList.get(i));
                innerList.add(num);
                outerList.add(innerList);
            }
        }

        return outerList;
    }


}
