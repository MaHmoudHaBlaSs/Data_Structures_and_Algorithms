/// https://leetcode.com/problems/find-xor-sum-of-all-pairs-bitwise-and/description/

class Solution {
    public int getXORSum(int[] arr1, int[] arr2) {
        return Arrays.stream(arr1).reduce(0, (a, b) -> a ^ b) 
            & Arrays.stream(arr2).reduce(0, (a, b) -> a ^ b);
    }
}