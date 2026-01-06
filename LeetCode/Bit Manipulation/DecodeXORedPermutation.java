/// https://leetcode.com/problems/decode-xored-permutation/description/

class Solution {
    public int[] decode(int[] encoded) {
        int mask = encoded[0], n = encoded.length+1;

        for(int i=1; i<=n; ++i) {
            mask ^= i;

            if((i & 1) == 0 && i<n-1) mask ^= encoded[i];    
        }
 
        int[] ans = new int[n]; 
        ans[n-1] = mask;

        for(int i=n-2; i>=0; --i){
            ans[i] = ans[i+1] ^ encoded[i];
        } 

        return ans;
    }
}