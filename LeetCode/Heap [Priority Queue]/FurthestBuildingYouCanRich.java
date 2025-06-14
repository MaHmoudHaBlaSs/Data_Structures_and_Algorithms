///   https://leetcode.com/problems/furthest-building-you-can-reach/description/

class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        Queue<Integer> pq = new PriorityQueue<>();
        int brickJumps = 0;

        for(int i=0; i<heights.length-1; i++){
            if(heights[i] >= heights[i+1]) continue;

            int diff = heights[i+1] - heights[i];
            if(pq.size() < ladders){ 
                pq.offer(diff);
            }
            else {
                int minDiff = diff;
                
                if(!pq.isEmpty() && minDiff > pq.peek()) {
                    minDiff = pq.poll();
                    pq.offer(diff);
                }
                
                if(brickJumps + minDiff > bricks) return i;
                
                brickJumps += minDiff;
            }
        }

        return heights.length-1; 
    }
}