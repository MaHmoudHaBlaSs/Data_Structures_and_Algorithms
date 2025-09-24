///  https://leetcode.com/problems/maximum-distance-between-a-pair-of-values/description/

class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int ans = 0; 
        int n1 = nums1.length, n2=nums2.length;
        int i=0, j=0;

        while(i < n1){
            while(j+1 < n2 && nums2[j+1] >= nums1[i]) j++;

            j = Math.max(j,i); 
            
            ans = Math.max(ans, j-i);

            i++;
        }

        return ans; 
    }
}