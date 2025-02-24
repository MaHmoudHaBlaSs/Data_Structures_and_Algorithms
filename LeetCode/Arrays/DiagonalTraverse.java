// https://leetcode.com/problems/diagonal-traverse/description/

class Solution {
    // T: O(n*m)      S: O(n*m)
    public  int[] findDiagonalOrder(int[][] mat) {
        int rows = mat.length, cols = mat[0].length;
        int i = 0, j = 0, ind = 0;
        int[] arr = new int[rows*cols];
        boolean goingUp = true;
        // We will control i and j based on direction Up or Down
        // Initially set to Up.

        while (i < rows && j < cols){
            arr[ind++] = mat[i][j];
            
            if (goingUp) { // Up
                i--; j++;
                if (i == -1 && j < cols){
                    i++;
                    goingUp = false;
                }else if (j == cols){
                    i += 2;
                    j--;
                    goingUp = false;
                }
            } else { // Down
                i++; j--;
                if (j == -1 && i < rows){
                    j++;
                    goingUp = true;
                } else if (i == rows){
                    i--;
                    j += 2;
                    goingUp = true;
                }
            }
        }
        return arr;
    }
}
