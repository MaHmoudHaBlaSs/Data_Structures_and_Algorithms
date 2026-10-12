///  https://leetcode.com/problems/sum-of-digit-differences-of-all-pairs/description/

class Solution {
    public long sumDigitDifferences(int[] nums) {
        int[][] freq = new int[10][10];
        int len = Integer.toString(nums[0]).length();

        for(int num : nums){
            for(int i=0; i<len; ++i){
                freq[i][num%10]++;
                num/=10;
            }
        }

        long ans = 0;
        for(int i=0; i<10; ++i){
            int m = nums.length;

            for(int j=0; j<10; ++j){
                m -= freq[i][j];
                ans += (long)freq[i][j] * m; 
            }
        }

        return ans;
    }
}