// https://leetcode.com/problems/subarray-sum-equals-k/description/

class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, arrays = 0;
        for (int num: nums){
            sum += num;
            arrays += map.getOrDefault(sum-k, 0);
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return arrays;
    }
}
