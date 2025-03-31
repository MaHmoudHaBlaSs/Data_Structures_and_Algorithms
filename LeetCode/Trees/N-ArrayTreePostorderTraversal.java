// https://leetcode.com/problems/n-ary-tree-postorder-traversal/description/

// Optimal.
// T: O(n)       S: O(1)
class Solution {
    List<Integer> list = new LinkedList<>();

    public List<Integer> postorder(Node root) {
        dfs(root);
        return list;
    }
    public void dfs(Node node){
        if (node == null) return;

        for (int i = 0; i < node.children.size(); i++)
            dfs(node.children.get(i));
        list.add(node.val);
    }
}