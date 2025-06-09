// https://leetcode.com/problems/course-schedule-ii

// Go Solve Course Schedule I.
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] topoSorted = new int[numCourses];
        int ind = 0;

        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegrees = new int[numCourses];

        for (int i = 0; i < numCourses; i++)
            graph.add(i, new ArrayList<>());

        for (int[] edge: prerequisites){
            graph.get(edge[1]).add(edge[0]);
            inDegrees[edge[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++){
            if (inDegrees[i] == 0)
                queue.add(i);
        }

        int polls = 0;
        while (!queue.isEmpty()){
            int polled = queue.poll();
            polls++;
            topoSorted[ind++] = polled;

            for (int neigh: graph.get(polled)){
                inDegrees[neigh]--;
                if (inDegrees[neigh] == 0)
                    queue.add(neigh);
            }
        }

        if (polls != numCourses)
            return new int[0];
        return topoSorted;
    }
}