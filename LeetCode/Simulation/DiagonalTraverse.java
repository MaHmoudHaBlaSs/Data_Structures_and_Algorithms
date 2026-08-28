///  https://leetcode.com/problems/diagonal-traverse/description/

class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int[] ans = new int[n*m];

        int r=0, c=0;
        boolean inc = true;

        for(int i=0; i<n*m; ++i){
            ans[i] = mat[r][c];

            if(inc){
                if(c == m-1){
                    r++;
                    inc = false;
                }else if(r == 0){
                    c++;
                    inc = false;
                }else{
                    r--;
                    c++;
                }
            }else{
                if(r == n-1){
                    c++;
                    inc = true;
                }else if(c == 0){
                    r++;
                    inc = true;
                }else {
                    r++;
                    c--;
                }
            }

        }

        return ans;
    }
}