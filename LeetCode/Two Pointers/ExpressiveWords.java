///  https://leetcode.com/problems/expressive-words/

class Solution {
    public int expressiveWords(String s, String[] words) {
        int ans =  0; 
        int sLen = s.length();

        for(String word : words){
            int wLen = word.length();
            if(wLen > sLen)
                continue;

            int i=0, j=0;
            boolean isQueryWord = true;

            while(i<wLen && j<sLen){
                if(word.charAt(i) != s.charAt(j)) //check the group start 
                {    
                    isQueryWord = false;
                    break;
                }
                
                int sGroup = j;
                while(j+1<sLen && s.charAt(j+1) == s.charAt(j))
                    j++;
                sGroup = j-sGroup+1;

                int wGroup = i;
                while(i+1<wLen && word.charAt(i+1) == word.charAt(i))
                    i++;
                wGroup = i-wGroup+1;
                

                if(wGroup > sGroup || (sGroup > wGroup && sGroup < 3)) {
                    isQueryWord = false;
                    break;
                }

                i++;   
                j++;
            }

            if(isQueryWord && i==wLen && j==sLen)
                ans++;
        }

        return ans;
    }
}