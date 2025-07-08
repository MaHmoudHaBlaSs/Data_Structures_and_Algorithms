///  https://leetcode.com/problems/find-the-punishment-number-of-an-integer/description/

class Solution {
    private boolean is(int iSquare, int i){
        if(i == 0) 
            return iSquare == 0;
        
        if(iSquare == 0) return false;

        for (int j = 10; j <= 1000000; j *= 10) {
            if(iSquare % j <= i){
                if(is(iSquare/j, i - (iSquare%j))) 
                    return true;
            }
            else break;
        }
        
        return false;
    }
    
    public int punishmentNumber(int n) {
        int count = 1;
        for (int i = 2; i <= n; i++) {
            if(is(i*i, i))
                count += i*i;
        }
        
        return count;
    }
}