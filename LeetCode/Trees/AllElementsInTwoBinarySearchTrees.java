// https://leetcode.com/problems/all-elements-in-two-binary-search-trees/?envType=problem-list-v2&envId=sorting


class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> result = new ArrayList<>();
        collectElements(root1, result);
        collectElements(root2, result);
        Collections.sort(result);
        return result;
    }

    private void collectElements(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        collectElements(root.left, result);
        result.add(root.val);
        collectElements(root.right, result);
    }
}