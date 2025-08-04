/// https://leetcode.com/problems/count-number-of-homogenous-substrings/description/

class Solution {
    public int countHomogenous(String s) {
        long ans = 0, n = s.length();
        for(int i=0; i<n; i++){
            int j=i;
            char c = s.charAt(i);

            while(j+1 < n && s.charAt(j+1) == c) j++;

            long len = j-i+1;  
            ans += (len + 1) * len / 2;
            i = j;
        }

        return (int) (ans % 1_000_000_007);
    }
}