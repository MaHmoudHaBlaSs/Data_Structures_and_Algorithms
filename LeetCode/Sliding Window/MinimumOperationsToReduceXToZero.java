///  https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/description/

/*
-As you can remove numbers the leftmost or the rightmost from the array: find a subarray satisfy this condition with sum = x. 
-The answer is a group of elements: arr[0 to i] or arr[j to n-1] to both of them.
-Sum of this two subarrays: arr[0 to i] + arr[j to n-1]  = totalSum - arr[i+1 to j-1]
*/

class Solution {
    private final int oo = 0x3f3f3f3f;

    public int minOperations(int[] nums, int x) {
        int ans = oo, totalSum = 0, n = nums.length;
        for (int num : nums) totalSum += num;

        if(totalSum < x) return -1;

        int left = 0, right = 0, currSum=0;
        while(left < n){
            while(totalSum - currSum > x && right < n){
                currSum += nums[right++];
            }

            if(totalSum - currSum == x)
                ans = Math.min(ans, n - (right - left));

            currSum -= nums[left++];
        }
        
        return ans == oo ? -1 : ans;
    }
}