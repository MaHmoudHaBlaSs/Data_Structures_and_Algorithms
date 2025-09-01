// https://leetcode.com/problems/transform-array-by-parity/

class Solution {
    public int[] transformArray(int[] nums) {
        int res[] = new int[nums.length];
        int index = 0;
        for(int n : nums){
            if(n % 2 == 0)
                res[index++] = 0;
            else 
                res[index++] = 1;
            
        }
        Arrays.sort(res);

        return res;

    }
}