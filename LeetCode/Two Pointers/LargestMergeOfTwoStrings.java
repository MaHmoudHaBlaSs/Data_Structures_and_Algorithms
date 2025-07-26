/// https://leetcode.com/problems/largest-merge-of-two-strings/description/

class Solution {
    public String largestMerge(String word1, String word2) {
        StringBuilder merge = new StringBuilder();
        int i = 0, j = 0;
        int n = word1.length(), m = word2.length();

        while (i < n || j < m) {
            if (i < n && (j == m || isGreater(word1,i,word2,j))) 
                merge.append(word1.charAt(i++));
            else 
                merge.append(word2.charAt(j++));
            
        }

        return merge.toString();
    }

    private boolean isGreater(String word1, int i, String word2, int j) {
        int n = word1.length(), m = word2.length();

        while (i < n && j < m) {
            if (word1.charAt(i) != word2.charAt(j))
                return word1.charAt(i) > word2.charAt(j);
            i++;
            j++;
        }
        return (n - i) > (m - j);
    }
}