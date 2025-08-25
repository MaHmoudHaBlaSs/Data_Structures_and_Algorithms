///  https://leetcode.com/problems/maximum-value-at-a-given-index-in-a-bounded-array/description/

class Solution {
    public int maxValue(int n, int index, int maxSum) {
        int ans = 1, left = 1, right = maxSum;

        while(left <= right){
            int mid = (left + right) / 2;  
            if(isValid(mid,index,n, maxSum)){
                ans = mid;
                left =mid+1;
            }
            else right = mid-1;
        }

        return ans; 
    }

    private boolean isValid(long mid, int idx, int n, long maxSum){
        long leftSum = rangeSum(mid-1-idx,mid-1);
        int rightLen = n - idx - 1;
        long rightSum = rangeSum(mid-1-rightLen, mid-1);

        return leftSum + mid + rightSum <= maxSum; 
    }

    private long rangeSum(long lower, long upper){
        long zeros = 0;
        if(lower < 0){ 
            zeros = -lower;
            lower = 0;
        }

        long s1 = (upper * (upper+1)) / 2;
        long s2 = (lower * (lower+1)) / 2;

        return s1-s2 + zeros;
    } 
}