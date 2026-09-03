package problems.disjoint_set;

import java.util.*;

public class LC0721AccountsMerge {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        int size = accounts.size();
        DSUImplementation dsu = new DSUImplementation(size);
        HashMap<String, Integer> emailMap = new HashMap<>();
        for(int i = 0; i< size; i++) {
            for(int j = 1; j< accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);
                if(!emailMap.containsKey(email)) {
                    emailMap.put(email, i);
                } else {
                    dsu.union(emailMap.get(email), i);
                }
            }
        }

        List<List<String>> mergedMails = new ArrayList<>(size);
        for(int i = 0; i < size; i++) {
            mergedMails.add(new ArrayList<String>());
        }

        for(Map.Entry<String, Integer> iter: emailMap.entrySet()) {
            String email = iter.getKey();
            int parent = dsu.findParent(iter.getValue());
            mergedMails.get(parent).add(email);
        }

        List<List<String>> ans = new ArrayList<>();

        for(int i = 0; i < size; i++) {
            if(mergedMails.get(i).size() == 0) continue;
            Collections.sort(mergedMails.get(i));
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for(String it: mergedMails.get(i)) {
                temp.add(it);
            }
            ans.add(temp);
        }
        return ans;

    }

}
