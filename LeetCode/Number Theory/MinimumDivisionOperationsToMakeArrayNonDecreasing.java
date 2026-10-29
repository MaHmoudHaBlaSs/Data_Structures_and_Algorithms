///  https://leetcode.com/problems/minimum-division-operations-to-make-array-non-decreasing/description/

class Solution {
    public int minOperations(int[] nums) {
        int ans = 0; 

        for(int i=nums.length-2; i>=0; --i){
            if(nums[i] > nums[i+1]){
                int div = smallestDivisor(nums[i]);
                if(div > nums[i+1]) 
                    return -1;

                nums[i] = div;
                ans++;
            }
        }

        return ans;
    }

    private int smallestDivisor(int num){
        for(int i=2; i*i<=num; ++i){
            if(num % i == 0) return i;
        }

        return num; 
    }
}