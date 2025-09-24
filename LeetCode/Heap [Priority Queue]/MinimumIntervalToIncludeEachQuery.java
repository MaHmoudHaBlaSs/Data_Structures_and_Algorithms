/// https://leetcode.com/problems/minimum-interval-to-include-each-query/description/

class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int qN = queries.length, iN = intervals.length;
        int[] ans = new int[qN];
        int[][] sortedQueries = new int[qN][2];

        for (int i = 0; i < qN; i++)
            sortedQueries[i] = new int[]{queries[i], i};

        Arrays.sort(sortedQueries, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int intervalIdx = 0;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> (a[1] - a[0])));

        for (int[] sortedQuery : sortedQueries) {
            while (intervalIdx < iN && intervals[intervalIdx][0] <= sortedQuery[0])
                minHeap.offer(intervals[intervalIdx++]);

            while (!minHeap.isEmpty() && minHeap.peek()[1] < sortedQuery[0])
                minHeap.poll();

            ans[sortedQuery[1]] = minHeap.isEmpty() ? -1 : minHeap.peek()[1] - minHeap.peek()[0] + 1;
        }

        return ans;
    }
}