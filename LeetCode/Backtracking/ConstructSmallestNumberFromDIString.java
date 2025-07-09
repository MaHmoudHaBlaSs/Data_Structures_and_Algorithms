// https://leetcode.com/problems/construct-smallest-number-from-di-string


class Solution {
    String res;
    StringBuilder smallest = new StringBuilder();
    boolean[] usedDigits = new boolean[10];
    boolean found = false;

    public String smallestNumber(String pattern) {
        Arrays.fill(usedDigits, false);
        getSmallest(pattern, -1, 0);
        return res;
    }
    public void getSmallest(String pattern, int step, int digit){

        // stop recursion when found
        if (step == pattern.length()){
            found = true;
            res = smallest.toString();
            return;
        }
            
        // Starting from 1 ascendingly guarantee the first solution we reach is the smallest lexo
        for (int i = 1; i < 10 && !found; i++){
            if (step != -1){
                if (usedDigits[i]) // Not used
                    continue;
                if ((pattern.charAt(step) == 'D' && i > digit) || (pattern.charAt(step) == 'I' && i < digit)) // Valid digit
                    continue;
            }

            // Do - Recurse - Undo
            usedDigits[i] = true;
            smallest.append(i);
            getSmallest(pattern, step+1, i);
            smallest.deleteCharAt(smallest.length()-1);
            usedDigits[i] = false;

        }
    }
}