///  https://leetcode.com/problems/score-of-parentheses/description/


class Solution {
    public int scoreOfParentheses(String s) {
        if(s.length() == 2) 
            return 1;
        
        int ans = 0; 
        int op = 0;
        StringBuilder str = new StringBuilder(); 
        boolean isStart = true; 

        for(int i=0; i<s.length();i++){
            if(isStart) {
                isStart = false;
                str = new StringBuilder(); 
                op++; 
            }
            else {
                if(s.charAt(i) == '('){
                    op++;
                    str.append('(');
                }
                else{ 
                    op--; 
                    str.append(')'); 
                }
            }

            if(op == 0) {
                str.deleteCharAt(str.length()-1); 
                
                if(str.length() != 0)  
                    ans += 2*scoreOfParentheses(str.toString());
                else ans++;

                isStart = true;
            }
        }

        return ans;
    }
}