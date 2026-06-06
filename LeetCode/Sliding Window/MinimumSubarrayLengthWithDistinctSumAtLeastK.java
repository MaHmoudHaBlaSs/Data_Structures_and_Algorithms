///   https://leetcode.com/problems/minimum-subarray-length-with-distinct-sum-at-least-k/description/


class Solution {
    public int minLength(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int l=0, sum=0, ans=Integer.MAX_VALUE;
        for(int r=0;r<nums.length;r++){
            int rightFreq = map.getOrDefault(nums[r], 0);

            if(rightFreq == 0) sum+=nums[r];
            
            map.put(nums[r], rightFreq+1);

            while(l<=r && sum>=k){
                int f = map.get(nums[l]);
                if(f == 1){
                    if(sum-nums[l] >= k) sum -= nums[l];
                    else break;
                }
                map.put(nums[l], f-1);
                l++;
            }
            
            if(sum >= k) ans = Integer.min(ans, r-l+1);
        }
        
        return ans == Integer.MAX_VALUE? -1 : ans;
    }

}
