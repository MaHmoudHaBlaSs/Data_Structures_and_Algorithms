/// https://leetcode.com/problems/shifting-letters/

//Time: O(n)         Space: O(n)
class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        int n = shifts.length; 
        long shift = 0; 
        char[] arr = s.toCharArray(); 


        for(int i=n-1; i>=0; i--){
            shift += shifts[i] % 26; 

            int inc = arr[i] - 'a';
            inc += shift;

            inc = inc % 26;
            arr[i] = (char)('a' + inc);  
        }

        return new String(arr);   
    }
}