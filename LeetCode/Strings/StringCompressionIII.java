///  https://leetcode.com/problems/string-compression-iii/description/

class Solution {
    public String compressedString(String word) {
        StringBuilder st = new StringBuilder();
        int n = word.length();
        for(int i=0; i<n; ){
            int j = i+1; 
            while(j<n && word.charAt(j) == word.charAt(i) && j-i<9) ++j;

            st.append(j-i);
            st.append(word.charAt(i));
            i = j;
        }

        return st.toString();
    }
}