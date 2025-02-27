// https://leetcode.com/problems/count-good-nodes-in-binary-tree/description/

class Solution {
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }
    // For balanced trees (best case) space complexity would be O(Log(n)) [Height of the tree] and for worst case
    // such that tree looks like LinkedList, the recursion would reach depth of n in the stack so the space complexity is O(n).
    // Time complexity is O(n) at any case because we check each node just one time.
    
    // T: O(n)           S:O(n) >> Because of stack (recursion)
    public int dfs(TreeNode node, int max){
        if (node == null) return 0;
        if (node.val >= max){
            return 1 + dfs(node.left, node.val) + dfs(node.right, node.val);
        }else{
            return 0 + dfs(node.left, max) + dfs(node.right, max);
        }
    }
}

// Another Implemention, same complexitites
class Solution {
    int nodes = 0;
    public int goodNodes(TreeNode root) {
        countGoods(root, root.val);
        return nodes;
    }
    public void countGoods (TreeNode node , int max){
        if (node == null) return;
        // Pre-Order traverse
        countGoods(node.left, Math.max(max, node.val));
        if (node.val >= max) nodes++;
        countGoods(node.right, Math.max(max, node.val));
    }
}
