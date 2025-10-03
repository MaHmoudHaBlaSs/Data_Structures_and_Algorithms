/// https://leetcode.com/problems/rotating-the-box/description/

class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int n = boxGrid.length, m = boxGrid[0].length; 
        char[][] ans = new char[m][n]; 

        for(int i=0; i<n; ++i){
            int next = m-1;
            for(int j=m-1; j>=0; --j){
                if(boxGrid[i][next] != '.') --next; 

                if(boxGrid[i][j] == '*') next = j-1;
                else if(boxGrid[i][j] == '#' && j < next){
                    boxGrid[i][next--] = '#';
                    boxGrid[i][j] = '.'; 
                }
            }

            for(int j=m-1; j>=0; --j)
                ans[j][n-i-1] = boxGrid[i][j]; 
        }

        return ans; 
    }
}