///   https://leetcode.com/problems/find-the-kth-smallest-sum-of-a-matrix-with-sorted-rows/description/

class Solution {
    public int kthSmallest(int[][] mat, int k) {
        int m=mat.length, n=mat[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        int sum = 0;
        for(int i=0; i<m; ++i) sum += mat[i][0];

        int[] arr = new int[m+1];
        arr[0] = sum;
        pq.add(arr);
        Set<String> visited = new HashSet<>();
        visited.add(Arrays.toString(arr)); 

        for(int i=1; i<k; ++i){
            int[] prev = pq.poll();
            for(int j=1; j<=m; ++j){
                if(prev[j] + 1 < n){
                    int[] next = Arrays.copyOf(prev,prev.length);
                    next[0] += mat[j-1][prev[j]+1] - mat[j-1][prev[j]];
                    next[j]++;

                    if(visited.add(Arrays.toString(next))){
                        pq.add(next);
                    }
                }
            }
        }

        return pq.poll()[0];
    }
}