///  https://leetcode.com/problems/sum-of-gcd-of-formed-pairs/description/


class Solution {
    public long gcdSum(int[] nums) {
        int mx = nums[0];
        for (int i = 0; i < nums.length; i++) {
            mx = Integer.max(mx, nums[i]);
            nums[i] = gcd(nums[i], mx);
        }

        Arrays.sort(nums);

        long ans = 0;
        int l=0, r= nums.length-1;
        while(l<r){
            ans += gcd(nums[l++], nums[r--]);
        }

        return ans;
    }

    private int gcd(int a, int b){
        while(b>0){
            int rem = a%b;
            a=b;
            b=rem;
        }

        return a;
    }
}