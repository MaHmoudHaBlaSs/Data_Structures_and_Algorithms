///  https://leetcode.com/problems/check-if-a-string-can-break-another-string/description/


class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        int[] freq1 = new int[26], freq2 = new int[26];
        int n = s1.length();

        for(int i=0; i<n; ++i){
            ++freq1[s1.charAt(i)-'a'];     
            ++freq2[s2.charAt(i)-'a'];     
        }

        int i=0, sum1=0, sum2=0; 
        while(i < 26 && sum1 <= sum2){
            sum1 += freq1[i];
            sum2 += freq2[i];
            ++i;
        } 

        if(i==26 && sum1 <= sum2) return true;

        i=25; sum1 = 0; sum2=0; 
        while(i >= 0 && sum1 <= sum2){
            sum1 += freq1[i];
            sum2 += freq2[i];
            --i;
        }    

        return sum1 <= sum2;             
    }
}