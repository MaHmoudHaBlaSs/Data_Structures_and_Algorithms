///  https://leetcode.com/problems/max-difference-you-can-get-from-changing-an-integer/description/


class Solution {
    public int maxDiff(int num) {
        int a=num,b=Integer.MAX_VALUE;
        String str = Integer.toString(num);

        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)!='9'){
                a = Integer.parseInt(str.replace(str.charAt(i),'9'));
                break;
            }
        }        
        
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)!='0'){
                b = Math.min(b, Integer.parseInt(str.replace(str.charAt(i), str.charAt(i) == str.charAt(0) ? '1' : '0')));
            }
        }
        
        
        return a-b;
    }
}