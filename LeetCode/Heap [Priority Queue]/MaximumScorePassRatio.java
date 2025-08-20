///  https://leetcode.com/problems/maximum-average-pass-ratio/

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a,b) -> {
            double diff1 = (a[0]+1)/(a[1]+1)- a[0]/a[1];
            double diff2 = (b[0]+1)/(b[1]+1)- b[0]/b[1];

            return Double.compare(diff2, diff1);
        });

        for (int[] c : classes) pq.add(new double[]{c[0], c[1]});

        while(extraStudents > 0){
            double[] top = pq.poll();
            top[0]++;
            top[1]++;

            pq.add(top);
            extraStudents--;
        }

        double sum = pq.stream().mapToDouble(arr -> arr[0] / arr[1]).sum();
        return sum / classes.length;
    }
}