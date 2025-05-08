///  https://leetcode.com/problems/find-longest-special-substring-that-occurs-thrice-ii/description/

class Solution {
    public int maximumLength(String s) {
        int[][] freq = new int[26][s.length()+1]; 
        char[] chars = s.toCharArray();
        
        for(int i=0; i< chars.length; i++){
            int left = i;
            char c = chars[left];
            while(i+1 < chars.length && chars[i+1] == c) i++;
            
            int len = i-left+1;
            for(int j=1; j<=len; j++)
                freq[c-'a'][j] += len-j+1;
        }
        
        int ans = -1; 
        for(var arr1 : freq)
            for(int i=1;i<s.length(); i++) 
                if(arr1[i] > 2) ans = Math.max(ans, i); 
          
        return ans;
    }
}