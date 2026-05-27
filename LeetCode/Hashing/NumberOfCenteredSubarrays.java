///  https://leetcode.com/problems/number-of-centered-subarrays/description/

class Solution {
    public int centeredSubarrays(int[] nums) {
        int ans = 0;

        for(int i=0; i<nums.length; ++i){
            HashSet<Integer> set = new HashSet<>();
            int sum = 0;

            for(int j=i; j>=0; --j){
                sum += nums[j]; 
                set.add(nums[j]);

                if(set.contains(sum)) ans++;
            }
        }

        return ans; 
    }
}