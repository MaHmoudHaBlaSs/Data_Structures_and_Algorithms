// https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal


// T: O(n)         S: O(n)
class Solution {

    public TreeNode bstFromPreorder(int[] preorder) {
        return generateTree(preorder, null, 0, preorder.length);
    }
    public TreeNode generateTree(int[] pre, TreeNode curr, int start, int end){
        if (start == end)// Base case
            return null;

        curr = new TreeNode(pre[start]);

        int i = start+1;
        while(i < pre.length && pre[i] < pre[start])
            i++;

        curr.left = generateTree(pre, curr.left, start+1, i);
        curr.right = generateTree(pre, curr.right, i, end);

        return curr;
    }
}