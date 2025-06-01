///   https://leetcode.com/problems/can-i-win/description/

class Solution {
    private Map<Integer, Boolean> memo = new HashMap<>();
    private int maxChoosableInteger;

    private boolean canWin(int mask, int total) {
        if (memo.containsKey(mask)) 
            return memo.get(mask);
        
        for (int i = 1; i <= maxChoosableInteger; i++) {
            if ((mask & (1 << i)) == 0) {
                if (total <= i || !canWin(mask | (1 << i), total - i)) {
                    memo.put(mask, true);
                    return true;
                }
            }
        }

        memo.put(mask, false);
        return false;
    }

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        this.maxChoosableInteger = maxChoosableInteger;
        
        if (maxChoosableInteger >= desiredTotal) 
            return true;
        
        //if sum of all numbers < desired total, no winner
        int sum = maxChoosableInteger * (maxChoosableInteger + 1) / 2;
        if (sum < desiredTotal) 
            return false;
        
        return canWin(0, desiredTotal);
    }
}