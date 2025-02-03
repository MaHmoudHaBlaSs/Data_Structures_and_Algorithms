// https://leetcode.com/problems/3sum/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); // O(nLog(n))
        List<List<Integer>> triplets = new LinkedList<>();

        for (int i = 0; i < nums.length; i++){
            int target = nums[i]*-1;
            int left = i+1, right = nums.length-1;
            
            if (i > 0 && nums[i] == nums[i-1])
                continue;
            if (nums[i] > 0)
                break;
            while (left < right){
                int sum = nums[left]+nums[right];
                
                if (sum > target)
                    right--;
                else if (sum < target)
                    left++;
                else {
                    triplets.add(List.of(nums[i], nums[left], nums[right]));
                    left++; right--;
                    while (left < right && nums[left-1] == nums[left])
                        left++;
                    while (left < right && nums[right+1] == nums[left])
                        right--;
                }
            }
        }
        return triplets;
    }
}
