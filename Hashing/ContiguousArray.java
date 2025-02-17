// https://leetcode.com/problems/contiguous-array/

class Solution {
    // T: O(n)      S: O(n)
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>(); map.put(0, -1);
        int maxArr = 0, sum = 0;
        for (int i = 0; i < nums.length; i++){
            sum += (nums[i] == 0)?-1:1;
            if (!map.containsKey(sum)) map.put(sum, i);
            else maxArr = Math.max(i-map.get(sum), maxArr);
        }
        return maxArr;
    }
}
