///    https://leetcode.com/problems/string-without-aaa-or-bbb/description/

class Solution {
    public String strWithout3a3b(int a, int b) {
        StringBuilder ans = new StringBuilder();
        int len = a+b;
        
        while(ans.length() < len){
            if(a > b){
                ans.append("aa");
                ans.append('b');
                a -= 2; 
                b--;
            }
            else if(b > a){
                ans.append("bb");
                ans.append('a');
                b -= 2;
                a--;
            }
            else {
                ans.append('a');
                ans.append('b');
            }
        }

        return ans.substring(0,len); 
    }

}