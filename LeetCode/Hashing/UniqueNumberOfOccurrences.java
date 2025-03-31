https://leetcode.com/problems/unique-number-of-occurrences/description/?envType=study-plan-v2&envId=leetcode-75


class Solution {
    public boolean uniqueOccurrences(int[] arr) {

        Set <Integer> occurrences = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : arr){
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }else{
                map.put(i, 1);
            }
        }
        for(int i : map.values()){
            if(occurrences.contains(i)){
               return false; 
            }else {
                occurrences.add(i);
            }
            
        }
        return true ;
        
    }
}
