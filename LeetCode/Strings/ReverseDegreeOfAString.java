// https://leetcode.com/problems/reverse-degree-of-a-string/description


class Solution {
    public int reverseDegree(String s) {
    int [] map = {26,25,24,23,22,21,20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1,0};
    int res = 0;
    for (int i = 0; i < s.length(); i++) {
        res += map[s.charAt(i) - 'a'] * (i + 1) ;
    }
    return res;

}
}