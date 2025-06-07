// https://leetcode.com/problems/course-schedule/

// Kahn's Algorithm
// T: O(n+v)                S: O(n+v)
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0) return true;

        Map<Integer, List> graph = new HashMap<>(numCourses);
        int[] inDegrees = new int[numCourses]; // How many edges entring the node

        // To ensure that isolated nodes are also included
        for (int i = 0; i < numCourses; i++){
            graph.put(i, new ArrayList<>());
            inDegrees[i] = 0;
        }

        for (int[] edge: prerequisites){
            if (edge[0] == edge[1]) return false;

            graph.get(edge[1]).add(edge[0]);
            inDegrees[edge[0]] += 1;
        }

        // Apply Kahn's Algorithm
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < numCourses; i++){
            if (inDegrees[i] == 0)
                queue.add(i);
        }
        if (queue.isEmpty()) return false;

        int pops = 0;
        while (!queue.isEmpty()){
            int popped = queue.poll();
            List<Integer> neighbours = graph.get(popped);

            for (int node: neighbours){
                inDegrees[node]--;
                if (inDegrees[node] == 0)
                    queue.add(node);
            }
            pops++;
        }
        return pops == numCourses;    
    }
}