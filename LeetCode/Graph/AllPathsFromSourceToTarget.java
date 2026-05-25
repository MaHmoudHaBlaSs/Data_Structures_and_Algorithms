// https://leetcode.com/problems/all-paths-from-source-to-target/?envType=problem-list-v2&envId=graph


// Backtracking
class Solution {
    List<List<Integer>> paths = new LinkedList<>();
    List<Integer> path = new LinkedList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        path.add(0);
        dfs(0, graph);
        return paths;
    }
    public void dfs(int node,int[][] graph){
        if (node == graph.length -1){ // Base Case
            paths.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < graph[node].length; i++){
            path.add(graph[node][i]); // Do
            dfs(graph[node][i], graph); // Recurse
            path.removeLast(); // Undo
        }   
    }
}

//BFS
class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>();
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.offer(new ArrayList<>(Arrays.asList(0)));

        for(int i = 0 ; i < graph.length ; i++){
            int nodeCount = queue.size();

            for(int j = 0 ; j < nodeCount ; j++){
            
                List<Integer> currentPath = queue.poll();
                int lastNode = currentPath.get(currentPath.size() - 1);
            
                if(lastNode == graph.length-1){
                    paths.add(currentPath);
                } else {
                    for (int neighbor : graph[lastNode]) {
                        List<Integer> newPath = new ArrayList<>(currentPath);
                        newPath.add(neighbor);
                        queue.offer(newPath);
                    }
                }
            
            }
        }
        return paths;
    }
}