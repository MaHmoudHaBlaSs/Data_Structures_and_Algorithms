///   https://leetcode.com/problems/smallest-string-starting-from-leaf/description/

class Solution {
    public String smallestFromLeaf(TreeNode root) {
        return dfs(root, "");
    }

    private String dfs(TreeNode node, String path) {
        if (node == null) return null;

        path = (char) (node.val + 'a') + path;
        if (node.left == null && node.right == null) return path;

        String left = dfs(node.left, path);
        String right = dfs(node.right, path);

        if (left == null) return right;
        if (right == null) return left;
        return left.compareTo(right) < 0 ? left : right;
    }
}