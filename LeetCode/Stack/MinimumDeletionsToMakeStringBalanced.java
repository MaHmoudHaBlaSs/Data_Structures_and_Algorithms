///  https://leetcode.com/problems/minimum-deletions-to-make-string-balanced/description/


//Can be solved using stack, or just a counter to simulate the stack.

class Solution {
    public int minimumDeletions(String s) {
        int bCount = 0, removed = 0;

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == 'b') 
                bCount++;
            else if(bCount > 0) {
                bCount--;
                removed++;
            }
        }   

        return removed;
    }
}