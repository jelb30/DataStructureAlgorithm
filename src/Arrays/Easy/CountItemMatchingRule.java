package Arrays.Easy;

import java.util.List;

public class CountItemMatchingRule {

    public static void main(String[] args) {

    }

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {

        int col = -1;

        if(ruleKey.equals("type")) col = 0;

        if(ruleKey.equals("color")) col = 1;

        if(ruleKey.equals("name")) col = 2;

        int count = 0;

        for(List<String> list: items){
            if(list.get(col).equals(ruleValue)) count++;
        }

        return count;

    }

}
