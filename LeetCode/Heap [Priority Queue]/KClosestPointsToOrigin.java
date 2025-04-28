// https://leetcode.com/problems/k-closest-points-to-origin/description/

// T: O(nLog(n))             S: O(n)
class Solution {
    class Pair implements Comparable<Pair>{
        double distance;
        int[] point;

        public Pair(double dist, int[] pnt){
            distance = dist;
            point = pnt;
        }

        @Override
        public int compareTo(Pair other){
            if (this.distance >= other.distance) return 1;
            else return -1;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> minHeap = new PriorityQueue<>();
        int[][] result = new int[k][2];
        
        for (int[] point: points){ // O(n)
            double dist = Math.sqrt(Math.pow(point[0], 2) + Math.pow(point[1], 2));
            minHeap.add(new Pair(dist, point)); // O(log(n))
        }

        for (int i = 0; i < k; i++)
            result[i] = minHeap.poll().point;
    
        return result;
    }
}