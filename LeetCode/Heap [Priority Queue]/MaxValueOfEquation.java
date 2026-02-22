///  https://leetcode.com/problems/max-value-of-equation/description/

class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (b[1]-b[0]) - (a[1]-a[0])); 
        int ans = Integer.MIN_VALUE;
        
        for(int[] point : points){
            while(!pq.isEmpty() && point[0] - pq.peek()[0] > k){
                pq.poll();
            }
            
            if(!pq.isEmpty()){
                int[] top =  pq.peek();
                ans = Math.max(ans, top[1] + point[1] + point[0] - top[0]);
            }

            pq.offer(point);
        }
        
        return ans;
    }
}
  