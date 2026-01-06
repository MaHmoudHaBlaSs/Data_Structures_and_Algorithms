/// https://leetcode.com/problems/find-kth-largest-xor-coordinate-value/description/

class Solution {
    public int kthLargestValue(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); 
        int n = matrix.length, m = matrix[0].length; 

        for(int i=0; i<n; ++i){
            for(int j=0; j<m; ++j){
                int val = matrix[i][j];

                if(i > 0) val ^= matrix[i-1][j];
                if(i > 0 && j > 0) val ^= matrix[i-1][j-1];
                if(j > 0) val ^= matrix[i][j-1];
                matrix[i][j] = val;

                pq.offer(val);
            }
        }

        for(int i=1; i<k; ++i) pq.poll();

        return pq.peek();
    }
}