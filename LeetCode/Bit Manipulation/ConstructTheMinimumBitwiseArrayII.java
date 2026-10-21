///  https://leetcode.com/problems/construct-the-minimum-bitwise-array-ii/description/

class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];

        for(int i=0; i<n; ++i){
            int num = nums.get(i);

            if((num&1) == 0){
                ans[i] = -1;
                continue;
            }
            
            ans[i] = num-1;

            for(int bit = 0; bit<32; ++bit){
                if((num & (1<<bit)) != 0){
                    int candidate = num ^ (1<<bit);
                    if((candidate | (candidate+1)) == num) 
                        ans[i] = candidate;
                }
            } 
        }

        return ans;
    }
}