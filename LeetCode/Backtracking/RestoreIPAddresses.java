// https://leetcode.com/problems/restore-ip-addresses/description/

class Solution {

    List<String> sol = new ArrayList<>();
    List<String> path = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        backtrack(0,s,0);
        return sol;
    }
    public void backtrack(int startIdx , String s,int countOfDos){
        if(countOfDos == 4 && startIdx == s.length()){ // Base Condition

            String validPath ="";

            for(String st : path) {

                validPath += st;

                validPath += ".";
            }
            
            sol.add(validPath.substring(0,validPath.length()-1));
        }

        // To avoid go beyond the base condition and avoid going into branches that can not be the solution
        // Ex: if left string is 5511135 -> len = 7 and we have 2 more steps so (7/2) = 3.5 (slot has 3 slots) -> useless branch
        if (countOfDos == 4 || ((s.length() - startIdx) / (4 - countOfDos) > 3)) 
            return;

        for (int len = 1; len <= 3; len++) {
            // 1. Boundary Check: Make sure we don't go past the end of the string
            if (startIdx + len > s.length()) break;

            // 2. Extract the substring
            String segment = s.substring(startIdx, startIdx + len);

            // 3. Validation Check: Is this a legal IP segment?
            if ( isValid(segment)){
                // DO: Add to path
                path.add(segment);

                // RECURSE: Move the index forward by the length we just took
                backtrack(startIdx + len, s, countOfDos + 1);

                // UNDO: Remove the last segment to try the next length
                path.remove(path.size() - 1);
            }
        }

    }
    private boolean isValid(String segment) {
        if (segment.length() > 1 && segment.startsWith("0")) return false;
        int val = Integer.parseInt(segment);
        return val >= 0 && val <= 255;
    }

}