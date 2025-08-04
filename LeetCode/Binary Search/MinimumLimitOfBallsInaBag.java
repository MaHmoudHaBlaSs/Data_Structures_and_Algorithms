///  https://leetcode.com/problems/minimum-limit-of-balls-in-a-bag/description/

class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int ans = 0, left = 1, right = Arrays.stream(nums).max().getAsInt();
        
        while(left <= right){
            int mid = (left+right)/2;
            if(can(nums,mid,maxOperations)){
                ans = mid;
                right= mid-1;
            }
            else left = mid+1;
        }

        return ans;
    }

    private boolean can(int[] nums, int penalty, int maxOperations){
        for(int n : nums){
            if(n > penalty){
                maxOperations -= (Math.ceilDiv(n,penalty) - 1);
                
                if(maxOperations < 0) return false;
            }
        }

        return maxOperations >= 0;
    }
}