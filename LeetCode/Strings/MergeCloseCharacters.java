///  https://leetcode.com/problems/merge-close-characters/description/


class Solution {
    public String mergeCharacters(String s, int k) {
        int[] lastSeen = new int[26]; 
        Arrays.fill(lastSeen, -100000);

        StringBuilder ans = new StringBuilder();

        for(int i=0; i<s.length(); ++i){
            char curr = s.charAt(i);

            if(ans.length()-lastSeen[curr-'a'] > k){
                lastSeen[curr-'a'] = ans.length();
                ans.append(curr);
            }
        }  

        return ans.toString();
    }
}