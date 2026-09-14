/// https://leetcode.com/problems/apply-operations-to-maximize-frequency-score/description/

class Solution {
    public int maxFrequencyScore(int[] nums, long k) {
        Arrays.sort(nums);

        long[] pref = new long[nums.length+1];
        
        for(int i=0; i<nums.length; ++i){
            pref[i+1] = pref[i] + nums[i];
        }

        int l=2, r=nums.length, ans=1;
        
        while(l<=r){
            int mid = (l+r) >> 1;

            if(canBeEqual(mid, pref, k)){
                ans = mid;
                l=mid+1;
            }else{
                r=mid-1;
            }
        }

        return ans;
    }

    private boolean canBeEqual(int len, long[] pref, long k){
        int hf = len/2;

        for(int i=len; i<pref.length; i++){
            long needed = pref[i] - pref[i - hf];

            if(len % 2 == 0)  needed -= (pref[i - hf] - pref[i-len]);
            else needed -= (pref[i - hf-1] - pref[i-len]);
            

            if(needed <= k) return true; 
        }            

        return false;
    }
}