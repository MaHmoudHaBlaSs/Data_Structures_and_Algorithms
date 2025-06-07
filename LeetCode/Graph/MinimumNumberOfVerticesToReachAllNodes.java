// https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes


// T: O(n+edges)                S: O(n)
class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        Set<Integer> unreachedNodes = new HashSet<>();

        // Assume I can't reach any node and the logic we follow will figure it out.
        for (int i = 0; i < n; i++) unreachedNodes.add(i); 

        for (var edge: edges){
            // target means the node is reachable
            unreachedNodes.remove(edge.get(1));
        }

        return unreachedNodes.stream().toList();
    }
}