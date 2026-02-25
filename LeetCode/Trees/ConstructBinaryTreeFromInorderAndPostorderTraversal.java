// https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/

// 1- The Last element in the postorder is the root 
// 2- we find the index of the root in the inorder array 
// 3- start divide the problem to left and right sub trees 
// 4- The base case is that the inorder is becoume empty of elemnts so we done

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        // Easier to handle than the arrays
        List<Integer> inorderList = new ArrayList<>();
        List<Integer> postorderList = new ArrayList<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderList.add(inorder[i]);
        }
        for (int i = 0; i < postorder.length; i++) {
            postorderList.add(postorder[i]);
        }
        return build(inorderList,postorderList);

    }
    public TreeNode build (List<Integer>inorder, List<Integer> postorder){
        if (inorder.isEmpty()) {
            return null;
        }

        int rootVal = postorder.remove(postorder.size() - 1);
        TreeNode root = new TreeNode(rootVal);

        
        int idx = inorder.indexOf(rootVal);

        
        root.right = build(inorder.subList(idx + 1, inorder.size()), postorder);
        root.left = build(inorder.subList(0, idx), postorder);

        return root;
    }
}