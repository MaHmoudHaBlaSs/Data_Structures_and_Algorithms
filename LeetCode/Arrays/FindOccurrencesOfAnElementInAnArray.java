///  https://leetcode.com/problems/find-occurrences-of-an-element-in-an-array/description/

class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        ArrayList<Integer> occ = new ArrayList<>();

        for(int i=0; i<nums.length; ++i){
            if(nums[i] == x){
                occ.add(i);
            }
        }

        int[] ans = new int[queries.length];
        for(int i=0; i<queries.length; ++i){
            if(queries[i] > occ.size())
                ans[i] = -1;
            else
                ans[i] = occ.get(queries[i]-1);
        }

        return ans;
    }
}