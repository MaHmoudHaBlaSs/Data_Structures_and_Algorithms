///  https://leetcode.com/problems/neighboring-bitwise-xor/description/

class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int mask = 0, n = derived.length;

        for(int i=0; i<n-1; i++){
            mask ^= derived[i];
        }  

        return (mask ^ derived[n-1]) == 0;
    }
}