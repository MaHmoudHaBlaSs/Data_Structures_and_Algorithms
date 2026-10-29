///  https://leetcode.com/problems/count-substrings-with-k-frequency-characters-i/description/

class Solution {
    public int numberOfSubstrings(String s, int k) {
        int[] freq = new int[26];
        int ans = 0, l=0, n = s.length(); 

        for(int r=0; r<n; ++r){
            freq[s.charAt(r) - 'a']++;

            while(l<=r && valid(freq, k)){
                ans += n-r;
                freq[s.charAt(l++) - 'a']--;
            }            
        }

        return ans;
    }

    private boolean valid(int[] freq, int k){
        for(int f : freq){
            if(f == k) return true; 
        }

        return false;
    }
}