// https://leetcode.com/problems/balance-a-binary-search-tree/description/

class Solution {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> sortedValues = new ArrayList<>();
        inOrderTraversal(root, sortedValues);
        return buildBalancedBST(sortedValues, 0, sortedValues.size() - 1);
    }
    public  void inOrderTraversal(TreeNode node, List<Integer> sortedValues) {
        if (node == null) return;
        inOrderTraversal(node.left, sortedValues);
        sortedValues.add(node.val);
        inOrderTraversal(node.right, sortedValues);
    }
    public TreeNode buildBalancedBST(List<Integer> sortedValues, int left, int right) {
        if (left > right) return null;
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(sortedValues.get(mid));
        node.left = buildBalancedBST(sortedValues, left, mid - 1);
        node.right = buildBalancedBST(sortedValues, mid + 1, right);
        return node;
    }

}