///   https://leetcode.com/problems/house-robber-iv/description/

//Time: O(n.log(n))                Spcae: O(1)
class Solution {
    private int[] houses;
    private int k,n;

    public int minCapability(int[] nums, int k) {
        houses = nums;
        this.k = k;
        n = nums.length; 

        int min = nums[0], max = nums[0]; 
        for(int num : nums){
            if(num > max) max = num;
            if(num < min) min = num; 
        }

        int ans = 0;
        while(min <= max){
            int capability = (min+max) / 2;

            if(canRob(capability)){
                ans  = capability; 
                max = capability -1;
            }
            else min = capability + 1;
        }

        return ans;
    } 

    //If the robber's capability = x, then he can only rob houses with money <= x
    private boolean canRob(int x){
        int count = 0, lastRobbed = -2;
        
        for(int i=0;i<n; i++){
            if(houses[i] <= x && lastRobbed != i-1) {
                count++;
                lastRobbed = i; 

                if(count == k) return true; 
            } 
        } 

        return false;
    }
}