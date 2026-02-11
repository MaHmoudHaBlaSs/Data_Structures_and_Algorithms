///  https://leetcode.com/problems/simplified-fractions/description/

class Solution {
    public List<String> simplifiedFractions(int n) { 
        List<String> list = new ArrayList<>();

        for(int den=2; den<=n; ++den){
            for(int num=1; num<den; ++num){
                if(gcd(den, num) == 1) {
                    list.add(num+"/"+den); 
                }
            }
        }

        return list;
    }

    private int gcd(int a, int b) {  
        while (b != 0) {
            int remainder = a % b;
            a = b;
            b = remainder;
        }
        return a;
    }    
}