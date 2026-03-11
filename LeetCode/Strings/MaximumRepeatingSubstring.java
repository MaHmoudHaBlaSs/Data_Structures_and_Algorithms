// https://leetcode.com/problems/maximum-repeating-substring/description/


class Solution {
    public int maxRepeating(String sequence, String word) {
        int maxRepeating = 0;
        int sequencePt = 0;
    
        while (sequencePt < sequence.length()) {
            int count = 0;
            int wordPt = 0;
            int tempSeqPt = sequencePt;
    
            while (tempSeqPt < sequence.length() &&
                    wordPt < word.length() &&
                    sequence.charAt(tempSeqPt) == word.charAt(wordPt)) {
                tempSeqPt++;
                wordPt++;
    
                if (wordPt == word.length()) {
                    count++;
                    wordPt = 0; 
                }
            }
    
            maxRepeating = Math.max(maxRepeating, count);
            sequencePt++;
        }
    
        return maxRepeating;
    }
}