/// https://leetcode.com/problems/count-nice-pairs-in-an-array/description/

class Solution {
    private final static int MOD = 1_000_000_007; 

    public int countNicePairs(int[] nums) {
        int count = 0; 
        HashMap<Integer, Integer> mp = new HashMap<>();

        for(int num : nums){
            int diff = num - rev(num); 
            int freq = mp.getOrDefault(diff, 0); 

            count = (count + freq) % MOD;
            mp.put(diff, freq+1);
        }

        return count;
    }

    private int rev(int num){
        int ans = 0;
        while(num != 0) {
            ans = ans*10 + num%10;
            num /= 10;
        }
        return ans;
    }
}