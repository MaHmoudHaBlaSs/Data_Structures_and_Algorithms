///   https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/description/

class Solution {
    //Time: O(n)          Space: O(1)
    public int numberOfSubstrings(String s) {
        int c = 0, right = 0, n = s.length(); 
        int[] mp = {0,0,0}; 

        for(int left=0; left<n; left++){
            while(right<n && (mp[0] == 0 || mp[1] == 0 || mp[2] ==0)){
                mp[s.charAt(right) - 'a']++;  
                right++; 
            }

            if(mp[0] > 0 && mp[1] > 0 && mp[2]>0) 
                c += (n-right+1); 

            mp[s.charAt(left)-'a']--;
        }

        return c;
    }
}