// https://leetcode.com/problems/greatest-common-divisor-of-strings/description/?envType=study-plan-v2&envId=leetcode-75


class Solution {
    public String gcdOfStrings(String str1, String str2) {
        
        if (!(str1 + str2).equals(str2 + str1)) {
            return ""; 
        }
        
        int gcdLength = gcd(str1.length(), str2.length());

        return str1.substring(0, gcdLength);
    }
    // Take it as it is "Algorithme d'Euclide" خوارزميه اقليدس لايجاد اكبر جزء مشترك
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}