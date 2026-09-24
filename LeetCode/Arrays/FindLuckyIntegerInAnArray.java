// https://leetcode.com/problems/find-lucky-integer-in-an-array/

class Solution {
    public int findLucky(int[] arr) {
        int [] freq = new int[501];
        for(int n : arr) freq[n]++;
        int res = -1;
        for (int i = 1; i < freq.length; i++) {
            if (i == freq[i]) res = i;
        }
        return res; 
    }
}