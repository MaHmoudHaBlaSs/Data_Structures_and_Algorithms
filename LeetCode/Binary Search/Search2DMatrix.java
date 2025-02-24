class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length;
        int left = 0, right = rows*cols-1;
        
        while (left <= right){
            int mid = (left+right)/2;
            int midI = mid/cols, midJ = mid%cols;

            if (target < matrix[midI][midJ])
                right = mid-1;
            else if (target > matrix[midI][midJ])
                left = mid+1;
            else 
                return true;
        }
        return false;
    }
}
