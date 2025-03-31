///   https://leetcode.com/problems/word-subsets/

//The definition of subset here doesn't require any order so check frequencies

//T: O(N * word.length)      S: O(n)
class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] freq = new int[26]; 

        for(String word : words2){
            int[] tmp = new int[26];
            int len = word.length(); 
            
            for(int i=0; i<len; i++) tmp[word.charAt(i) - 'a']++; 

            for(int i=0; i<26; i++) freq[i] = Math.max(freq[i], tmp[i]); 
        }

        List<String> ans =  new ArrayList<>(); 
        for(String word : words1){
            int[] tmp = new int[26];
            int len = word.length(); 
            
            for(int i=0; i<len; i++) tmp[word.charAt(i) - 'a']++; 

            boolean isUnique = true;
            for(int i=0; i<26; i++){
                if(freq[i] > tmp[i]) {
                    isUnique =  false;
                    break;
                }
            }

            if(isUnique) ans.add(word);
        }        

        return ans; 
    }

}