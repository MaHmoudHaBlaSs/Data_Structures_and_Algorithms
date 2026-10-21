///  https://leetcode.com/problems/find-the-k-th-character-in-string-game-ii/description/

class Solution {
    public char kthCharacter(long k, int[] operations) {
        return (char)('a' + (solve(k-1, operations)%26));
    }

    private int solve(long k, int[] operations){
        if(k == 0) return 0;
        if(k == 1) return operations[0];

        long mod = Long.highestOneBit(k);
        
        int idx = 0;
        long modCopy = mod;
        while(modCopy > 0){
            idx++; 
            modCopy >>= 1;
        }

        return solve(k%mod, operations) + operations[idx-1];
    }   
}