// https://leetcode.com/problems/maximum-subsequence-score/description

class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;

        // [ [num1] , [num2] ] 
        int[][] pairs = new int[n][2];
        for(int i = 0; i < n; i++){
            pairs[i][0] = nums1[i];
            pairs[i][1] = nums2[i];
        }

        // Sort by nums2 DESC
        Arrays.sort(pairs, (a, b) -> b[1] - a[1]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long sum = 0;
        long maxScore = 0;

        for(int i = 0; i < n; i++){
            sum += pairs[i][0];
            pq.add(pairs[i][0]);

            // Keep only k elements
            if(pq.size() > k){
                sum -= pq.poll();
            }

            // When we have exactly k elements
            if(pq.size() == k){
                maxScore = Math.max(maxScore, sum * pairs[i][1]);
            }
        }

        return maxScore;
    }
}