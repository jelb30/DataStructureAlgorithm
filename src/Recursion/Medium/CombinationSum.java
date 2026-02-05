package Recursion.Medium;

import java.util.*;

// MEANS WE CAN USE NUMBERS MULTIPLE TIMES TO FORM THE SUM!
public class CombinationSum {

    public int[] candidates;

    public void implmentation(int[] candidates, int target){
        this.candidates = candidates;
        Arrays.sort(this.candidates);

        List<List<Integer>> potentialCandidates = new ArrayList<>();

        combinationSum2Index(potentialCandidates, new ArrayList<>(), target, 0);

        for (List<Integer> list : potentialCandidates) {
            System.out.println("Potential Candidates: " + list);
        }


    }

    // SO THIS ONE HERE IS THE SOLUTION FOR THE COMBINATION SUM 1, AS WE TAKE THE INDEX ONLY 2 TIMES AND ONLY SUBSEQUENTLY!
    // SO IT CAN BE [2,2,3] BUT IT CAN'T BE [2,3,2] OR [3,2,2].
    // IT ONLY DIFFERS FROM THE TOP ONE BY ONLY ADDING THE INDEX PARAMETER.
    public List<List<Integer>> combinationSumIndex(List<Integer> processed, int target, int index){
        List<List<Integer>> finalList = new ArrayList<>();

        if(target==0){
            finalList.add(new ArrayList<>(processed));
            return finalList;
        }

        for (int i = index; i < this.candidates.length; i++) {
            if(this.candidates[i]<= target) {
                int temp = this.candidates[i];
                processed.add(temp);
                finalList.addAll(combinationSumIndex(processed, target - temp, i));
                processed.remove(processed.size() - 1);
            }
        }
        return finalList;
    }


    // THIS ONE HERE GIVES ALL THE POSSIBLE COMBINATIONS AND ALL THE ORDERS!!
    // LIKE [2,2,3] & [2,3,2]
    // NOT THE COMBINATION SUM 1 SOLUTION, MAYBE FOR COMBINATION SUM 2! LOL!!
    public List<List<Integer>> combinationSum(List<Integer> processed, int target){
        List<List<Integer>> finalList = new ArrayList<>();

        if(target==0){
            finalList.add(new ArrayList<>(processed));
            return finalList;
        }

        for (int i = 0; i < this.candidates.length; i++) {
            int temp = this.candidates[i];
            if(temp <= target){
                processed.add(temp);
                finalList.addAll(combinationSum(processed, target-temp));
                processed.remove(processed.size()-1);
            }
        }
        return finalList;
    }


    // ACTUAL SOLUTION THAT WORKED!
    // EXPECT SORTED ARRAY! SO WE SORT THE ARRAY BEFORE THIS FUNCTION!
    public void combinationSum2Index(List<List<Integer>> finalList, List<Integer> processed, int target, int index){

        if(target==0){
            finalList.add(new ArrayList<>(processed));
            return ;
        }

        for (int i = index ; i < this.candidates.length; i++) {

            int currentNum = this.candidates[i];

            // REMOVING ALL THE DUPLICATES!
            if(i > index && currentNum == this.candidates[i-1]){
                continue;
            }

            // LIST IS SORTED SO THERE WONT BE ANY MEANING TO TRAVERSE FURTHER!
            if(currentNum> target) break;

            processed.add(currentNum);
            combinationSum2Index(finalList, processed, target - currentNum, i+1);
            processed.remove(processed.size() - 1);

        }
    }
}