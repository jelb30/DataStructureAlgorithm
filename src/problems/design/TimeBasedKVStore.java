package problems.design;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TimeBasedKVStore {

    HashMap<String, List<Pair>> map;

    public static class Pair {
        String value;
        int timestamp;
        public Pair(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    public TimeBasedKVStore() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair(value, timestamp));
    }


    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) {
            return "";
        }
        String result = "";
        List<Pair> pairs = map.get(key);
        int low = 0;
        int high = pairs.size()-1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if(pairs.get(mid).timestamp <= timestamp) {
                result = pairs.get(mid).value;
                low = mid+1;
            } else {
                high = mid -1;
            }
        }
        return result;
    }

}
