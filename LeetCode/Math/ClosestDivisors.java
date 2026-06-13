// https://leetcode.com/problems/closest-divisors/description/

class Solution {
    public int[] closestDivisors(int num) {
        int num1 = num + 1;
        int num2 = num + 2;
        int[] res = new int[2];
        int minDiff = Integer.MAX_VALUE;
        
        
        for (int i = (int) Math.sqrt(num1); i >= 1; i--) {
            if (num1 % i == 0) {
                int j = num1 / i;
                int diff = Math.abs(j - i);
                if (diff < minDiff) {
                    minDiff = diff;
                    res[0] = i;
                    res[1] = j;
                }
                break; // because starting from sqrt gives closest pair
            }
        }
        
    
        for (int i = (int) Math.sqrt(num2); i >= 1; i--) {
            if (num2 % i == 0) {
                int j = num2 / i;
                int diff = Math.abs(j - i);
                if (diff < minDiff) {
                    minDiff = diff;
                    res[0] = i;
                    res[1] = j;
                }
                break; 
            }
        }
        
        return res;
    }
}