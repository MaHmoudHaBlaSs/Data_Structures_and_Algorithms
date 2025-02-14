// https://leetcode.com/problems/3sum/

class Solution {
    // T: O(n2)
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplets = new LinkedList<>();
        Arrays.sort(nums);

        // T: O(n)
        for (int i = 0; i < nums.length; i++){
            int left = i+1, right = nums.length-1;
            
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i-1]) continue;

            // T: O(m)
            while (left < right){
                int sum = nums[i]+nums[left]+nums[right];
                if (sum > 0)
                    right--;
                else if (sum < 0)
                    left++;
                else{
                    triplets.add(new LinkedList(List.of(nums[i], nums[left], nums[right])));
                    do{left++;}
                    while(left < right && nums[left] == nums[left-1]);
                    do{right--;}
                    while(left < right && nums[right] == nums[right+1]);
                }
            }
        }
        return triplets;
    }
}
