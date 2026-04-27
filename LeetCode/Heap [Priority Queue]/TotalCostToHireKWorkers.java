// https://leetcode.com/problems/total-cost-to-hire-k-workers/description/

class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        long totalCost = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });

        int left = 0;
        int right = n - 1;

        for (; left < candidates; left++) {
            pq.offer(new int[]{costs[left], left});
        }

        for (int i = 0; i < candidates && right >= left; i++) {
            pq.offer(new int[]{costs[right], right});
            right--;
        }

        for (int hireCount = 0; hireCount < k; hireCount++) {
            int[] curr = pq.poll();
            totalCost += curr[0];
            int idx = curr[1];

            if (left <= right) {
                if (idx < left) {
                    pq.offer(new int[]{costs[left], left});
                    left++;
                } else if (idx > right) {
                    pq.offer(new int[]{costs[right], right});
                    right--;
                }
            }
        }

        return totalCost;
    }
}