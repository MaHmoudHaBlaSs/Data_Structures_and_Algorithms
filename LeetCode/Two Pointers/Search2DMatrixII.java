// https://leetcode.com/problems/search-a-2d-matrix-ii/description/

class Solution {

    // T: O(n+m) >> O(n)
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0, j = matrix[0].length-1;
        while (i < matrix.length && j >= 0){
            if (matrix[i][j] == target) return true;
            if (matrix[i][j] > target)
                j--;
            else 
                i++;
        }
        return false;
    }
  
    // Binary Search Solution >> T: O(nLog(m))
    public boolean searchMatrix(int[][] matrix, int target) {
        int cols = matrix[0].length;
        for (int i = 0; i < matrix.length; i++){
            int left = 0, right = cols-1;
            
            while (left <= right){
                int mid = (left+right)/2;

                if (matrix[i][mid] > target)
                    right = mid-1;
                else if (matrix[i][mid] < target)
                    left = mid+1;
                else 
                    return true;
            }
        }
        return false;
    }
}
