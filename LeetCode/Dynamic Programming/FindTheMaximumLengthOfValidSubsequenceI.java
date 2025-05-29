/// https://leetcode.com/problems/find-the-maximum-length-of-valid-subsequence-i/

class Solution {
    public int maximumLength(int[] nums) {
        int evenEven = 0, oddOdd = 0,evenOdd = 0, oddEven = 0;

        for(int num : nums){
            if((num & 1) == 0){
                oddOdd++;
                evenOdd = oddEven + 1;
            }
            else {
                evenEven++;
                oddEven = evenOdd +1;
            }
        }

        return Math.max(evenEven , Math.max(oddOdd, Math.max(evenOdd, oddEven)));
    }
}