// https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers

// Just observe the pattern no logic there [Don't use math because it will cause overflow].
// Hints are usefull
// T: O(n)            S: O(1)
class Solution {
    public int minPartitions(String n) {
        int binaryUsed = 0;

        for (char digit: n.toCharArray())
            binaryUsed = Math.max(binaryUsed, Character.getNumericValue(digit));

        return binaryUsed;
    }
}
