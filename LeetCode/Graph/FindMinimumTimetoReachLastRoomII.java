// https://leetcode.com/problems/find-minimum-time-to-reach-last-room-ii/description/


class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length, m = moveTime[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); // {cell, dist}
        boolean[] isOne = new boolean[n*m], visited = new boolean[n*m];

        isOne[0] = true;
        pq.offer(new int[] {0,0});

        while(!pq.isEmpty()){
            //1-get the node with the smallest dist
            int[] top = pq.poll();
            int source = top[0], dist = top[1];

            if(visited[source]) continue;
            if(source == (n*m - 1)) return dist;

            //2-mark as visited
            visited[source] = true;

            //update neighbors
            int i = source/m , j = source % m;
            int neb1 = ((i+1) * m) + j, neb2 = i*m + j+1;
            int neb3 = ((i-1) * m) + j, neb4 = i*m + j-1;

            if(i+1 < n && !visited[neb1]){
                int neb1Dist = dist + (isOne[source] ? 1 : 2) +  Math.max(0, moveTime[i+1][j] - dist);
                pq.offer(new int[]{neb1, neb1Dist});
                isOne[neb1] = !isOne[source];
            }
            if(i-1 >= 0 && !visited[neb3]){
                int neb3Dist = dist + (isOne[source] ? 1 : 2) +  Math.max(0, moveTime[i-1][j] - dist);
                pq.offer(new int[] {neb3, neb3Dist});
                isOne[neb3] = !isOne[source];
            }

            if(j+1 < m && !visited[neb2]){
                int neb2Dist = dist + (isOne[source] ? 1 : 2) +  Math.max(0, moveTime[i][j+1] - dist);
                pq.offer(new int[] {neb2, neb2Dist});
                isOne[neb2] = !isOne[source];
            }
            if(j-1 >= 0 && !visited[neb4]){
                int neb4Dist = dist + (isOne[source] ? 1 : 2) +  Math.max(0, moveTime[i][j-1] - dist);
                pq.offer(new int[]{neb4, neb4Dist});
                isOne[neb4] = !isOne[source];
            }
        }

        return 0;
    }
}