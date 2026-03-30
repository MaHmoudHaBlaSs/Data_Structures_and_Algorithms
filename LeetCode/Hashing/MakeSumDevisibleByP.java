/// https://leetcode.com/problems/make-sum-divisible-by-p/description/

class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        
        long total = 0;
        for (int num : nums) {
            total = (total + num) % p;
        }

        if (total == 0) return 0;

        HashMap<Long, Integer> mp = new HashMap<>();
        mp.put(0L, -1);

        long curr = 0;
        int ans = n;

        for (int i = 0; i < n; i++) {
            curr = (curr + nums[i]) % p;

            long needed = (curr - total + p) % p;

            if (mp.containsKey(needed)) {
                ans = Math.min(ans, i - mp.get(needed));
            }

            mp.put(curr, i);
        }

        return ans == n ? -1 : ans;
    }
}