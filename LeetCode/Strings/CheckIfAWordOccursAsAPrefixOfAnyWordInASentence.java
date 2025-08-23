// https://leetcode.com/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence

// T: O(n)      S: O(1)
class Solution {
    public int isPrefixOfWord(String sentence, String word) {
        int wordIndx = 0;
        int j = 0;

        for(int i = 0; i < sentence.length(); i++){
            if (sentence.charAt(i) == ' ' || i == 0){
                int temp = (i == 0)?i: i+1;

                while (sentence.charAt(temp) == word.charAt(j)){
                    j++; temp++;

                    if (j == word.length()) return wordIndx+1;
                    if (temp == sentence.length()) break;
                }

                wordIndx++;
                j = 0;
            }
        }
        return -1;
    }
}