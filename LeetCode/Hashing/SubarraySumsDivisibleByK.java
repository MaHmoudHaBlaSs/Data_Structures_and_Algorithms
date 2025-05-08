//   https://leetcode.com/problems/subarray-sums-divisible-by-k/description/

/*
-This is the straightforward solution: (pref[j] - pref[i]) % k = 0, which is O(n^2).
-Module property tells it's tha same as: pref[j]%k - pref[i]%k = 0 -->> pref[j]%k == pref[i]%k.
-Simply if we stand at index j and rem = pref[j]%k, we have to know how many time this rem occured before.
*/

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> mp = new HashMap<>(); 
        int prefix = 0, ans = 0;
        mp.put(0,1);
        
        for(int i=0; i<nums.length; i++){
            prefix += nums[i]; 

            int rem = prefix % k;
            if(rem < 0) rem += k; 

            int count = mp.getOrDefault(rem,0);
            ans += count; 
            mp.put(rem, count+1); 
        }

        return ans; 
    }
}