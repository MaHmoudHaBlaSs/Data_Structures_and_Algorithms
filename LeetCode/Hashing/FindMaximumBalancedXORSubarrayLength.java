///  https://leetcode.com/problems/find-maximum-balanced-xor-subarray-length/description/

class Solution {
    public int maxBalancedSubarray(int[] nums) {
        HashMap<Integer, HashMap<Integer, Integer>> mp = new HashMap<>();
        mp.put(0, new HashMap<>()); 
        mp.get(0).put(0,-1);

        int mask = 0, odd = 0, even = 0, ans = 0;

        for(int i=0; i<nums.length; ++i){
            mask ^= nums[i];

            if(nums[i] % 2 == 0) even++;
            else odd++;
            
            mp.putIfAbsent(mask, new HashMap<>());
            var diffIdx = mp.get(mask); 

            int currLen = i - diffIdx.getOrDefault(odd-even, i);
            ans = Integer.max(ans, currLen); 

            diffIdx.putIfAbsent(odd - even, i); 
        }

        return ans;
    }
}