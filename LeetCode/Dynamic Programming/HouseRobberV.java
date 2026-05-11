///  https://leetcode.com/problems/house-robber-v/description/

class Solution {
    public long rob(int[] nums, int[] colors) {
        int n = nums.length;
        long curr = nums[0], prev=0;

        for(int i=1; i<n; ++i){
            long newCurr = 0;
            
            if(colors[i] == colors[i-1]){
                newCurr = Long.max(prev + nums[i], curr);
            } else{
              newCurr = curr + nums[i];
            }
            
            prev = curr;
            curr = newCurr; 
        }

        return curr;
    }
}