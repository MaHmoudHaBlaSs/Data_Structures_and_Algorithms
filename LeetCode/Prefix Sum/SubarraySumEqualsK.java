///  https://leetcode.com/problems/subarray-sum-equals-k/description/

class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int sum = 0, ans = 0;

        mp.put(0, 1);

        for(int num : nums){
            sum += num; 
            ans += mp.getOrDefault(sum-k, 0);

            mp.put(sum, mp.getOrDefault(sum,0)+1);
        }

        return ans;
    }
}