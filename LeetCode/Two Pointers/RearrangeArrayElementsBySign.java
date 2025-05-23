// https://leetcode.com/problems/rearrange-array-elements-by-sign/description

// T: O(n)                   S: O(n)
class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] res = new int[nums.length];
        int neg = 0, pos = 0;

        for(int i = 0; i < res.length; i++){
            while (neg < res.length && nums[neg] > 0)
                neg++;
            while (pos <  res.length && nums[pos] < 0)
                pos++;
                
            res[i] = (i%2 == 0)? nums[pos++]: nums[neg++];
        }
        return res;
    }
}