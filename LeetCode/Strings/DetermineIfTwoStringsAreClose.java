///  https://leetcode.com/problems/determine-if-two-strings-are-close/description/

class Solution {
    public boolean closeStrings(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        if(len1 != len2) return false;

        int[] freq1 = new int[26], freq2 = new int[26];
        for (int i = 0; i < len1; i++) {
            freq1[word1.charAt(i) - 'a']++;
            freq2[word2.charAt(i) - 'a']++;
        }

        for(int i=0; i<26; i++){
            if(freq1[i] == 0 || freq1[i] == freq2[i]) continue;
            if(freq2[i] == 0) return false;

            for (int j = i; j < 26; j++) {
                if(freq2[j] == freq1[i]){
                    swap(i,j,freq2);
                    break;
                }
            }
            
            if(freq1[i] != freq2[i]) return false;
        }

        return true;
    }

    private void swap(int i,int j, int[] arr){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}