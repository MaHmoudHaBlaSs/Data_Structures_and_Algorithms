///  https://leetcode.com/problems/find-the-lexicographically-largest-string-from-the-box-i/description/

class Solution {
    public String answerString(String word, int numFriends) {
        if(numFriends == 1) return word;
        
        int maxLen = word.length() - numFriends + 1;
        int ansStart = 0;
        char[] arr = word.toCharArray();

        for(int i=1; i<arr.length; i++){
            int j=0, n = Math.min(i+maxLen, arr.length);
            while(i+j < n && arr[i+j] == arr[ansStart + j]) j++;
            
            if(i+j < n && arr[i+j] > arr[ansStart+j]) ansStart = i;
        }
        
        return word.substring(ansStart, Math.min(ansStart+maxLen, arr.length));
    }
}