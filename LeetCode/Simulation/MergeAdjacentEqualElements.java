///   https://leetcode.com/problems/merge-adjacent-equal-elements/description/


class Solution {
    public List<Long> mergeAdjacent(int[] nums) {
        List<Long> list = new ArrayList<>(); 
        list.add((long)nums[0]); 

        for(int i=1; i<nums.length; ++i){
            long curr = nums[i];
            
            while(!list.isEmpty() && curr == list.getLast()){
                list.removeLast(); 
                curr = curr<<1;
            }

            list.add(curr); 
        }

        return list;
    }
}