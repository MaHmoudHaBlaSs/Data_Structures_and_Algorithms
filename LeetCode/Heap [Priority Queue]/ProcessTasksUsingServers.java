/// https://leetcode.com/problems/process-tasks-using-servers/description/

class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        PriorityQueue<int[]> available = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });

        PriorityQueue<long[]> busy = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) return Long.compare(a[1], b[1]);
            return Long.compare(a[0], b[0]);
        });

        for (int i = 0; i < servers.length; i++) {
            available.offer(new int[]{servers[i], i});
        }

        int[] result = new int[tasks.length];
        long time = 0;

        for (int i = 0; i < tasks.length; i++) {
            time = Math.max(time, i);

            while (!busy.isEmpty() && busy.peek()[0] <= time) {
                long[] done = busy.poll();
                available.offer(new int[]{servers[(int)done[1]], (int)done[1]});
            }

            if (available.isEmpty()) {
                time = busy.peek()[0];
                while (!busy.isEmpty() && busy.peek()[0] <= time) {
                    long[] done = busy.poll();
                    available.offer(new int[]{servers[(int)done[1]], (int)done[1]});
                }
            }

            int[] server = available.poll();
            result[i] = server[1];
            busy.offer(new long[]{time + tasks[i], server[1]});
        }

        return result;
    }
}