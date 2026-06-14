///  https://leetcode.com/problems/reverse-words-with-same-vowel-count/description/

class Solution {
    public String reverseWords(String s) {
        String[] arr = s.split(" "); 

        int count = countVowels(arr[0]), n = arr.length;

        StringBuilder sb = new StringBuilder(); 
        sb.append(arr[0]);

        for(int i=1; i<arr.length; ++i){
            sb.append(' ');
            
            if(count == countVowels(arr[i])){
                for(int j=arr[i].length()-1; j>=0; --j){
                    sb.append(arr[i].charAt(j));
                }
            }else{
                sb.append(arr[i]);
            }            
        } 

        return sb.toString(); 
    }

    private int countVowels(String st){
        int c = 0;
        for(int i=0; i<st.length(); ++i){
            if(isVowel(st.charAt(i))) c++;
        }

        return c;
    }
    private boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'u' || c == 'o';
    }
}
