///  https://leetcode.com/problems/minimum-k-to-reduce-array-within-limit/description/

class Solution {
    public int minimumK(int[] nums) {
        int l=1, r=1_000_00, ans = 0; 

        while(l<=r){
            int mid = (r+l) >> 1;
            
            if(nonPositive(nums, mid) <= (long) mid*mid){
                r = mid-1;
                ans = mid; 
            }
            else{
                l = mid+1; 
            }
        }

        return ans; 
    }

    private long nonPositive(int[] nums, int k){
        long ans = 0; 
        for(int num : nums){
            ans += Math.ceilDiv(num,k); 
        }

        return ans;
    }
}