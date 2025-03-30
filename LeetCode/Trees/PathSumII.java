// 

// Optimal
// S: O(n)             S: O(1) -> output not included in space complexity.
class Solution {
    int sum = 0;
    List<List<Integer>> paths = new LinkedList<>(); // O(n)
    List<Integer> path = new LinkedList<>(); // O(1)

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return paths;
    }
    
    public void dfs (TreeNode node, int target){
        if (node == null) return;
        sum += node.val;
        path.add(node.val);

        if (sum == target && node.left == null && node.right == null){
            paths.add(new ArrayList<>(path));
            sum -= node.val;
            path.removeLast();
            return;
        }

        dfs(node.left, target);
        dfs(node.right, target);
        sum -= node.val;
        path.removeLast();
    }
}