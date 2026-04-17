// https://leetcode.com/problems/counting-bits/description/

class Solution {
    public int[] countBits(int n) {
        int [] res =new int [n+1];
        for(int i = 0 ; i <= n ; i++ ){
            res[i] = onesCount(i);
        }
        return res;

    }
    public int onesCount(int num){
        int count = 0;
        while(num > 0 ){
            int r = num & 1;
            if(r == 1 )count++;
            num = num >> 1;
            
        }
        return count;
    }
}