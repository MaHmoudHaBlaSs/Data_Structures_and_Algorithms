// https://leetcode.com/problems/3sum-closest/description/

public class Solution {
    public int ThreeSumClosest(int[] nums, int target)
    {
        Array.Sort(nums); 
        int closestSum = nums[0] + nums[1] + nums[2]; 

        for (int i = 0; i < nums.Length - 2; i++)
        {
            int left = i + 1;
            int right = nums.Length - 1;

            while (left < right)
            {
                int currentSum = nums[i] + nums[left] + nums[right];
                if (Math.Abs(currentSum - target) < Math.Abs(closestSum - target))
                {
                    closestSum = currentSum;
                }
                if (currentSum < target)
                {
                    left++;
                }
                else if (currentSum > target)
                {
                    right--;
                }
                else
                {
                    return currentSum;
                }
            }
        }

        return closestSum; 
    }
}