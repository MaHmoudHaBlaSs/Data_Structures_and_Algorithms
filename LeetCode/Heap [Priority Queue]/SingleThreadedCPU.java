///  https://leetcode.com/problems/single-threaded-cpu/description/


class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[][] sortedTasks = new int[n][3];
        for (int i = 0; i < tasks.length; i++) {
            sortedTasks[i][0] = tasks[i][0];
            sortedTasks[i][1] = tasks[i][1];
            sortedTasks[i][2] = i;
        }

        Arrays.sort(sortedTasks, (a, b) -> { 
            if (a[0] != b[0]) return a[0] - b[0];
            if (a[1] != b[1]) return a[1] - b[1];
            return a[2] - b[2];
        });

        int[] result = new int[n];
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) ->{ 
            if(a[1] != b[1]) return a[1] - b[1];
            return a[2] - b[2]; 
        });

        int resultIndex = 0;
        int currentTaskIndex = 0;
        long availableAt = 0;

        while (resultIndex < n) {
            while (currentTaskIndex < n && availableAt >= sortedTasks[currentTaskIndex][0]) {
                queue.add(sortedTasks[currentTaskIndex++]);
            }

            int[] nextTask = queue.isEmpty() ? sortedTasks[currentTaskIndex++] : queue.poll();
            result[resultIndex++] = nextTask[2];
            availableAt = Math.max(nextTask[0], availableAt) + nextTask[1];
        }


        return result;
    }
}