//https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/description/


class Solution {
        int solCount;
        String result;

        public String getHappyString(int n, int k) {
            result = "";
            backtrack(new StringBuilder(),n,k);
            return result;
        }

        public void backtrack(StringBuilder s ,int  n  , int k){
            if(s.length() == n ){
                solCount++; // found new sol
                if(solCount == k ){
                    result = s.toString(); // target founded
                }
                return;
            }

            char[] options = {'a','b','c'};
            for(char ch : options){
                
                // Don't recurse if 1. the next branch char is equal to the last choosen char, 2. we found the solution.
                if ( (!s.isEmpty() && s.charAt(s.length() - 1) == ch) || !result.equals("") )
                    continue;

                s.append(ch); // do
                backtrack(s,n,k); // recurse
                s.deleteCharAt(s.length() - 1 ); // undo

            }
        }
}