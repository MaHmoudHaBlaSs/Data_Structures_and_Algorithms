/// https://leetcode.com/problems/form-array-by-concatenating-subarrays-of-another-array/description/

class Solution {
    public boolean canChoose(int[][] groups, int[] nums) {
        int nextStart = 0;

        for(int[] group : groups){
            nextStart = getMatch(nums, group, nextStart);

            if(nextStart == -1) return false;
        }  

        return true; 
    }

    private int getMatch(int[] nums, int[] group, int start){
        int n=nums.length, gLen = group.length;

        for(int i=start; i<n; i++){
            if(nums[i] != group[0]) continue;
            
            int j=i+1, k=1;
            while(j < n && k < gLen && nums[j] == group[k]) {
                j++;
                k++;
            }

            if(k == gLen) return j;
        }

        return -1;
    }
}

