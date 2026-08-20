// https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/description/

class Solution {
    public int countNegatives(int[][] grid) {
        int cols = grid[0].length;
        int count = 0;

        for(int[] row : grid){
            int low = 0;
            int high = cols - 1 ;
            while(low <= high){
                int mid = low + (high - low) / 2 ;

                if (row[mid] < 0)
                    high = mid - 1;
                else
                    low = mid + 1;
            }
            count += cols - low;

        }
        return count;
    }
}