// https://leetcode.com/problems/largest-component-size-by-common-factor

import java.util.*;

class Solution {
    // Think about prime factors
    // N^2 is not acceptable
    public int largestComponentSize(int[] nums) {
        Map<Integer, Integer> factorsMap = new HashMap<>();
        Map<Integer, Integer> disjSets = new HashMap<>();
        int largest = 1;

        for ( int num: nums ){
            if (disjSets.containsKey(num) || num == 1) continue;

            List<Integer> factors = getFactors(num);
            for ( int factor: factors ){
                if (factorsMap.containsKey(factor)){ // union
                    int targetParent = getParent(factorsMap.get(factor), disjSets);
                    int currParent = getParent(num, disjSets);
                    if (currParent == targetParent) continue; // same set

                    disjSets.put( targetParent, disjSets.get(targetParent) + disjSets.getOrDefault(currParent, -1) );
                    disjSets.put( currParent, targetParent);

                    largest = Math.max(largest, -1 * disjSets.get(targetParent));
                }
                else {
                    factorsMap.put(factor, num);
                    disjSets.putIfAbsent(num, -1);
                }
            }
        }
        return largest;
    }

    private List<Integer> getFactors(int num){
        List<Integer> res = new LinkedList<>();

        for (int i = 2; i <= (int)Math.ceil(Math.sqrt(num)); i++){
            if (num % i == 0)
                res.addAll(List.of(i, num/i));
        }
        res.add(num);

        return res;
    }

    private int getParent(int num, Map<Integer, Integer> sets){
        if (!sets.containsKey(num)) return num;

        int parent = num;
        while (sets.get(parent) > 0)
            parent = sets.get(parent);

        if (num != parent)
            sets.put(num, parent); // Enhancement for future access

        return parent;
    }
}