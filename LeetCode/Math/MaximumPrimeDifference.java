///  https://leetcode.com/problems/maximum-prime-difference/description/

class Solution {
    public int maximumPrimeDifference(int[] nums) {
        boolean[] prime = new boolean[103];
        Arrays.fill(prime, true);
        prime[1] = false;

        for(int i=2; i*i < 103; ++i){
            if(prime[i]){
                for(int m=i+i; m<103; m+=i) 
                    prime[m] = false;
            }
        }


        int idx = -1, ans = 0;
        for(int i=0; i<nums.length; ++i){
            if(prime[nums[i]]){
                if(idx == -1) idx = i;
                else ans = i-idx;
            }
        }

        return ans;
    }
}