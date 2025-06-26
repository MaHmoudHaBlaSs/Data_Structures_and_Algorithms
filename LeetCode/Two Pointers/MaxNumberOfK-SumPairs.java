///  https://leetcode.com/problems/max-number-of-k-sum-pairs/description/


public class Solution{
    public int maxOperations(int[] nums, int k) {
        int left = 0, right = nums.length-1, ans = 0;
        Arrays.sort(nums);

        while(left < right){
            int currSum = nums[left] + nums[right];
            if(currSum == k) {
                left++;
                right--;
                ans++;
            }
            else if(currSum > k) right--;
            else left++;
        }
        
        return ans;
    }
}

