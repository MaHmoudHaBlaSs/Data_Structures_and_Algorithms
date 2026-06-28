///  https://leetcode.com/problems/minimum-absolute-distance-between-mirror-pairs/description/


class Solution {
    public int minMirrorPairDistance(int[] nums) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int ans = Integer.MAX_VALUE;

        for(int i=0; i<nums.length; ++i){
            if(mp.containsKey(nums[i])){
                ans = Integer.min(ans, i - mp.get(nums[i]));
            }

            mp.put(reverse(nums[i]), i);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int reverse(int num){
        int ans  = 0;

        while(num>0){
            ans *= 10;
            ans += (num%10);
            num /= 10;
        }

        return ans;
    }
}