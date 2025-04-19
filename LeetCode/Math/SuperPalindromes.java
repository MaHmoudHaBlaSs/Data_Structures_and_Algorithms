///        https://leetcode.com/problems/super-palindromes/

/*
HINTS: 
1- If x = y^2 is a super palindrome, then the sum of squares of all digits in y must be less than 10. 
2- All digits of y are 0,1,2 
*/

class Solution {
    private List<Long> superPalindromes = new ArrayList<>();
    private List<String> sqrts = new ArrayList<>();

    private void generate(){
        sqrts.addAll(List.of("1","2","3","11","22"));

        for(int i=3; i<sqrts.size(); i++){
            String num = sqrts.get(i);
            if(num.length() >= 9) break; 

            if(num.length() % 2 == 0){
                String op1 = new StringBuilder(num).insert(num.length()/2,'0').toString();
                String op2 = new StringBuilder(num).insert(num.length()/2,'1').toString();
                String op3 = new StringBuilder(num).insert(num.length()/2,'2').toString();

                if(valid(op1)) sqrts.add(op1);
                if(valid(op2)) sqrts.add(op2);
                if(valid(op3)) sqrts.add(op3);
            }
            else {
                char mid = num.charAt(num.length()/2);
                String op1 = new StringBuilder(num).insert(num.length()/2,mid).toString();
                if(valid(op1)) sqrts.add(op1);
            }
        }

        for(String num : sqrts){
            Long n = Long.parseLong(num);
            superPalindromes.add(n*n);
        }
    }

    private boolean valid(String num){
        int twos = 0, ones = 0;

        for(int i=0; i<num.length(); i++)
            if(num.charAt(i) == '2') twos++;
            else if(num.charAt(i) == '1') ones++;

        return ones + twos*4 < 10;
    }

    public int superpalindromesInRange(String left, String right) {
        generate();
        Long l = Long.parseLong(left), r = Long.parseLong(right);

        int count = 0;
        for(Long num : superPalindromes)
            if(num >= l && num <= r) count++;
        
        return count; 
    }
}