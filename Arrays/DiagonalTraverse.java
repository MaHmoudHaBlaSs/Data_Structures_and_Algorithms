// https://leetcode.com/problems/diagonal-traverse/description/

class Solution {
public  int[] findDiagonalOrder(int[][] mat) {
        int rows = mat.length, cols = mat[0].length;
        int i = 0, j = 0, arr[] = new int[rows*cols];
        int ind = 0;
        boolean goingUp = true;
        // We will control i and j based on direction Up or Down
        // Initially set to Up.

        while (i < rows && j < cols){
            if (goingUp){
                arr[ind] = mat[i][j];
                i--;
                j++;

                if (i < 0 && j < cols){
                    i++;
                    goingUp = false;
                } else if (j >= cols){
                    i += 2;
                    j--;
                    goingUp = false;
                }
            }else{ // Going Down
                arr[ind] = mat[i][j];
                i++;
                j--;

                if (j < 0 && i < rows){
                    j++;
                    goingUp = true;
                } else if (i >= rows){
                    j += 2;
                    i--;
                    goingUp = true;
                }
            }
            ind++;
        }
        return arr;
    }
}
