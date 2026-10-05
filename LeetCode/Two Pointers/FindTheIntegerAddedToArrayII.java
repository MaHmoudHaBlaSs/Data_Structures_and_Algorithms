/// https://leetcode.com/problems/find-the-integer-added-to-array-ii/description/

class Solution {
    public int minimumAddedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int ans = Integer.MAX_VALUE;
        int op1 = nums2[0] - nums1[0];
        int op2 = nums2[0] - nums1[1];
        int op3 = nums2[0] - nums1[2];

        if(reachable(1,1, op1, 0, nums1, nums2)) ans = op1;
        if(reachable(2,1, op2, 1, nums1, nums2)) ans = Integer.min(op2, ans);
        if(reachable(3,1, op3, 2, nums1, nums2)) ans = Integer.min(op3 , ans);

        return ans;
    }

    private boolean reachable(int i, int j, int diff, int removed, int[] nums1, int[] nums2){
        if(i >= nums1.length || j >= nums2.length) return true;

        if(nums2[j] - nums1[i] == diff){
            return reachable(i+1, j+1, diff, removed, nums1, nums2);
        }

        if(removed == 2) return false;

        return reachable(i+1, j, diff, removed+1, nums1, nums2);
    }
}