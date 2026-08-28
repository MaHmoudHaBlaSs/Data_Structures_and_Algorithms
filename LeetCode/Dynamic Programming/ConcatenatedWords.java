///  https://leetcode.com/problems/concatenated-words/description/

class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        HashSet<String> wordsSet = new HashSet<>(Arrays.asList(words));
        
        List<String> result = new ArrayList<>();
        for (String word : words){
            Boolean[] memo = new Boolean[word.length()];

            if(isConcatenatedWord(0, word, wordsSet, memo,0)){
                result.add(word);
            }
        }
        
        return result;
    }
    
    private boolean isConcatenatedWord(int index, String word, HashSet<String> wordsSet, Boolean[] memo, int count) {
        if (index == word.length()) {
            return count >= 2;
        }

        if (memo[index] != null && count > 0) {
            return memo[index];
        }

        for (int end = index + 1; end <= word.length(); end++) {
            String part = word.substring(index, end);

            if (wordsSet.contains(part)) {

                if (isConcatenatedWord(end, word, wordsSet, memo, count + 1)) {
                    return true;
                }
            }
        }

        if (count > 0) {
            memo[index] = false;
        }

        return false;
    }

}