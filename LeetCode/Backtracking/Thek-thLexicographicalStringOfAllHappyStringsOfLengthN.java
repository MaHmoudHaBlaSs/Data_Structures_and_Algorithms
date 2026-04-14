//https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/description/


class Solution {
        int solCount;
        String result;
        public String getHappyString(int n, int k) {
            result="";
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

                if(!s.isEmpty()&& s.charAt(s.length() - 1) == ch ) continue;

                s.append(ch); // do
                backtrack(s,n,k); // recurse


                if (!result.equals("")) return; // that's mean we found the solution
                
                s.deleteCharAt(s.length() - 1 ); // undo

            }


        }
}