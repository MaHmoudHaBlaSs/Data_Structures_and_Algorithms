///  https://leetcode.com/problems/subarrays-with-k-different-integers/description/

/*
-You can't count Subarrays with exactly K different integers directly in O(N), but 
you can count subarrays with at most k distinct integers in O(N).
-Using this relationship which is derived from the principle of inclusion-exclusion in counting:
    count(exactly k distinct) = count(at most k distinct) - count(at most k-1 distinct)
*/

class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return subArraysWithAtMostK(nums, k) - subArraysWithAtMostK(nums, k-1);
    }

    private int subArraysWithAtMostK(int[] nums, int k){
        int[] freq = new int[nums.length + 1];
        int distinct = 0, right = 0, n = nums.length, ans = 0;

        for(int left=0; left<n; left++){

            while(distinct <= k && right < n){
                if(freq[nums[right]]++ == 0)
                    distinct++;

                right++;
                ans += right - left;
            }
            
            if(distinct <= k) ans++;

            if(freq[nums[left]]-- == 1) 
                distinct--;
        }

        return ans;
    }  
}