// https://leetcode.com/problems/spiral-matrix/description/

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new LinkedList<>();
        int rows = matrix.length, cols = matrix[0].length;
        int i = 0, j = 0, dir = 1, step = 0; // Step will control the boundaries
        while (list.size() <  rows*cols ){
            list.add(matrix[i][j]);

            if (dir == 1){
                j++;
                if (j == cols-step){ // Right
                    j--;
                    i++;
                    dir = 2; // Go Down
                }
            } else if (dir == 2){ // Down
                i++;
                if (i == rows-step){
                    i--;
                    j--;
                    dir = 3; // Go Left
                }
            } else if (dir == 3){ // Left
                j--;
                if (j == -1+step){
                    j++;
                    i--;
                    dir = 4; // Go Up
                }
            } else { // dir == 4 (Up)
                i--;
                if (i == 0+step){
                    i++;
                    j++;
                    dir = 1; // Go Right
                    step++; // Next Turn
                }
            }
        }
        return list;
    }
}
