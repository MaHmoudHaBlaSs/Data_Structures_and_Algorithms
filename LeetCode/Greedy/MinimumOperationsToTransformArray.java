///  https://leetcode.com/problems/minimum-operations-to-transform-array/description/


class Solution {
    public long minOperations(int[] nums1, int[] nums2) {
        long ans = 0;
        int n = nums1.length, closest = Math.abs(nums1[0] - nums2[n]);

        for(int i=0; i<n; ++i){
            ans += Math.abs(nums1[i] - nums2[i]);

            if(nums2[n] >= Math.min(nums1[i], nums2[i])
                && nums2[n] <= Math.max(nums1[i], nums2[i]))
                    closest = 0;
            else {
                closest = Math.min(closest, Math.abs(nums2[n]-nums1[i]));
                closest = Math.min(closest, Math.abs(nums2[n]-nums2[i]));
            }
        }

        return ans + closest + 1; 
    }
}