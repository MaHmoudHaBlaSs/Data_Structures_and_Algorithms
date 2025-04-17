// https://leetcode.com/problems/clone-graph/description/

// T: O(n)             S: O(n)
class Solution {
    Map<Integer, Node> created = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Node newNode = new Node(node.val);
        created.put(newNode.val, newNode);
        dfs(newNode, node);
        return newNode;
    }
    public void dfs(Node newNode, Node node){
        for (Node neighbor: node.neighbors){
            if (created.containsKey(neighbor.val)){
                newNode.neighbors.add(created.get(neighbor.val));
            }else{
                Node newNeighbor = new Node(neighbor.val);
                created.put(newNeighbor.val, newNeighbor);
                newNode.neighbors.add(newNeighbor);
                dfs(newNeighbor, neighbor);
            }
        }
    }
}