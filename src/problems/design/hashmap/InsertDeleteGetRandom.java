package problems.design.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class InsertDeleteGetRandom {

    private HashMap<Integer , Integer> map;
    private ArrayList<Integer> list;

    public InsertDeleteGetRandom() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if(map.containsKey(val)) {
            return false;
        }
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if(!map.containsKey(val)) {
            return false;
        }
        //getting index of the val
        int index = map.get(val);
        //getting last element in list
        int last = list.get(list.size()-1);

        //replacing deleted with last one.
        list.set(index, last);
        map.put(last, index);

        list.remove(list.size()-1);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        int random = (int) (Math.random() * list.size());
        return list.get(random);
    }

}
