///  https://leetcode.com/problems/constrained-subsequence-sum/description/


class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        int ans = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            while(!pq.isEmpty() && i - pq.peek()[0] > k) pq.poll();
            
            int num = nums[i];
            int val = pq.isEmpty() ? num : Math.max(pq.peek()[1]+num, num);
            ans = Math.max(ans, val);
            pq.offer(new int[]{i, val});
        }
        
        return ans;
    }
}