///  https://leetcode.com/problems/count-of-substrings-containing-every-vowel-and-k-consonants-i/description/

class Solution {
    public int countOfSubstrings(String word, int k) {
        int[] freq = new int[26];
        int n = word.length(), ans = 0; 


        for(int i=0; i<n; ++i){
            HashSet<Character> vowels = new HashSet<>();
            int non = 0;

            for(int j=i; j<n; ++j){
                if(isVowel(word.charAt(j))){
                    vowels.add(word.charAt(j));
                }else{
                    non++;
                }

                if(non > k) break;

                if(non == k && vowels.size() == 5) ans++;
            }
        }

        return ans;
    }

    private boolean isVowel(char c){
        return c == 'a' || c=='e'|| c == 'o' || c == 'i' || c=='u';
    }
}