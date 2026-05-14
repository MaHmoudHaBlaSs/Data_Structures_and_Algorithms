// https://leetcode.com/problems/find-eventual-safe-states/description

class Solution {

    private Set<Integer> path = new HashSet<>();
    private Set<Integer> safeNodes = new TreeSet<>();
    private Set<Integer> visited = new HashSet<>();

    public List<Integer> eventualSafeNodes(int[][] graph) {

        for (int i = 0; i < graph.length; i++){
            if (!visited.contains(i)){
                explore(i, graph, path);
                path.clear();
            }
        }
        return new ArrayList<Integer>(safeNodes);
    }

    private boolean explore(int i, int[][] graph, Set<Integer> path){
        if ( path.contains(i) )
            return false;

        if ( visited.contains(i) ){
            if ( safeNodes.contains(i) )
                return true;
            else
                return false;
        }

        if ( graph[i].length == 0 ){
            visited.add(i);
            safeNodes.add(i);
            return true;
        }

        path.add(i);
        for (int node: graph[i]){
            if ( !explore(node, graph, path) ){
                visited.add(i);
                return false;
            } 
        }
        path.remove(i);

        visited.add(i);
        safeNodes.add(i);
        return true;
    }
}