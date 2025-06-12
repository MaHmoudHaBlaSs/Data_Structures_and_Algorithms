// https://leetcode.com/problems/binary-search-tree-iterator

class BSTIterator {
    Stack<TreeNode> stack;


    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        fillStack(root);
    }

    public int next() {
        TreeNode popped = stack.pop();
        if (popped.right != null)
            fillStack(popped.right);
        
        return popped.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public void fillStack(TreeNode node){
        while (node != null){
            stack.push(node);
            node = node.left;
        }
    }
}
