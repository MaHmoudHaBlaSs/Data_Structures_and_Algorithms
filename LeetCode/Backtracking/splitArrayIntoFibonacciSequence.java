///   https://leetcode.com/problems/split-array-into-fibonacci-sequence/

//T: O(2^n),   S: O(n)
class Solution {
    private List<Integer> result;
    private String num;
    private int len;

    public List<Integer> splitIntoFibonacci(String num) {
        this.result = new ArrayList<>();
        this.num = num;
        this.len = num.length();
        
        solve(0);
        return result;
    }

    private boolean solve(int index) {
        if (index == len) {
            return result.size() >= 3;
        }

        // Handle leading zeros (only valid as a single digit 0)
        if (num.charAt(index) == '0') {
            if (canAddNumber(0)) {
                result.add(0);
                if (solve(index + 1)) return true;
                result.remove(result.size() - 1);
            }
            return false; 
        }

       
        long current = 0;
        for (int j = index; j < len; j++) {
            current = current * 10 + (num.charAt(j) - '0');
            
            if (current > Integer.MAX_VALUE) break;
            
            int currentInt = (int) current;
            
            if (canAddNumber(currentInt)) {
                result.add(currentInt);
                if (solve(j + 1)) return true;
                result.remove(result.size() - 1);
            }
        }
        
        return false;
    }
    
    private boolean canAddNumber(int num) {
        if (result.size() < 2) return true;    
        
        long sum = (long) result.get(result.size() - 1) + result.get(result.size() - 2);
        return sum == num;
    }
}