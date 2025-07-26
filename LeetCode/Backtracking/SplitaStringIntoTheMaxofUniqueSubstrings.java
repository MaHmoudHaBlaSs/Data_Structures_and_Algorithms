/// https://leetcode.com/problems/split-a-string-into-the-max-number-of-unique-substrings/description/

class Solution {
    private HashSet<String> set = new HashSet<>();
    
    private int solve(int i, String s){
        if(i == s.length()) return 0;

        int ans = -1;
        for(int j=i; j<s.length(); j++){
            String sub = s.substring(i,j+1); 
            if(!set.contains(sub)) {
                set.add(sub);
                ans = Math.max(ans, 1 + solve(j+1, s));
                set.remove(sub);
            }
        }

        return ans; 
    }

    public int maxUniqueSplit(String s) {
        return solve(0,s);
    }
}