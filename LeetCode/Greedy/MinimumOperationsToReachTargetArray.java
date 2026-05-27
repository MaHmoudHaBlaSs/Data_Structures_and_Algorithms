///   https://leetcode.com/problems/minimum-operations-to-reach-target-array/description/


class Solution {
    public int minOperations(int[] nums, int[] target) {
        int ans = 0;
        HashSet<Integer> chosen = new HashSet<>(); 

        for(int i=0; i<nums.length; ++i){
            if(nums[i] != target[i]){
                if(!chosen.contains(nums[i])){
                    ans++;
                    chosen.add(nums[i]);
                }
            }
        }

        return ans;
    }
}