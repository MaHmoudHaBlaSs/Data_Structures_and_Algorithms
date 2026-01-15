/// https://leetcode.com/problems/find-the-longest-substring-containing-vowels-in-even-counts/description/

class Solution {
    public int findTheLongestSubstring(String s) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0,-1);

        int ans=0, mask=0;

        for (int i = 0; i < s.length(); i++) {
            if(isVowel(s.charAt(i)))
                mask ^= 1 << (s.charAt(i)-'a');

            if(mp.containsKey(mask)){
                ans = Math.max(ans, i-mp.get(mask));
            }else{
                mp.put(mask, i);
            }
        }

        return ans;
    }

    private boolean isVowel(char ch){
        return ch == 'a' || ch == 'e' || ch == 'u' || ch == 'i' || ch == 'o'  ;
    }
}