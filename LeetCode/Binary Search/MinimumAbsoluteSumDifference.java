/// https://leetcode.com/problems/minimum-absolute-sum-difference/description/

class Solution {
    private static final int MOD = 1_000_000_007;

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int[] sortedArr = Arrays.copyOf(nums1, nums1.length);
        Arrays.sort(sortedArr);

        int highestReduction = 0, replacementIdx = 0, replacement = nums1[0];
        for (int i = 0; i < nums1.length; i++) {
            int closest = closestNum(sortedArr, nums2[i]);
            int oldDiff = Math.abs(nums1[i] - nums2[i]), newDiff = Math.abs(closest - nums2[i]);
            
            if(oldDiff - newDiff > highestReduction){
                highestReduction = oldDiff - newDiff;
                replacementIdx = i;
                replacement = closest;
            }
        }
        
        nums1[replacementIdx] = replacement;
        
        long ans = 0;
        for (int i = 0; i < nums1.length; i++) {
            ans = (ans + Math.abs(nums1[i]- nums2[i])) % MOD;
        }
        
        return (int)ans; 
    }

    private int closestNum(int[] sortedArr, int target){
        int ans=-1, left=0, right=sortedArr.length-1;
        while(left <= right){
            int mid = (left+right)/2;

            if(sortedArr[mid] <= target){
                ans = mid;
                left = mid+1;
            }
            else right = mid-1;
        }

        if(ans == -1) return sortedArr[0];
        if(ans == sortedArr.length-1) return sortedArr[ans];

        return Math.abs(sortedArr[ans] - target) <= Math.abs(sortedArr[ans+1] - target) ? sortedArr[ans] : sortedArr[ans+1];
    }
}