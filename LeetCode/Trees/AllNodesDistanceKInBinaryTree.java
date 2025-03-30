///       https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/

//Turn it into a graph and run a BFS from the target

class Solution {
    private Map<Integer, List<Integer>> adj;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        if (root == null || target == null) return ans;
        if (k == 0) {
            ans.add(target.val);
            return ans;
        }

        adj = new HashMap<>();
        buildGraph(root);

        if (!adj.containsKey(target.val)) return ans; 

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.offer(target.val);
        visited.add(target.val);

        int level = 0;
        while (!q.isEmpty() && level <= k) {
            int size = q.size();
            if (level == k) {
                ans.addAll(q);
                break;
            }
            
            while (size-- > 0) {
                int node = q.poll();
                for (int neighbor : adj.getOrDefault(node, Collections.emptyList())) {
                    if (!visited.contains(neighbor)) {
                        q.offer(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
            level++;
        }

        return ans;
    }

    private void buildGraph(TreeNode root) {
        adj.putIfAbsent(root.val, new ArrayList<>());
        
        if (root.left != null) {
            adj.putIfAbsent(root.left.val, new ArrayList<>());
            adj.get(root.val).add(root.left.val);
            adj.get(root.left.val).add(root.val);
            buildGraph(root.left);
        }

        if (root.right != null) {
            adj.putIfAbsent(root.right.val, new ArrayList<>());
            adj.get(root.val).add(root.right.val);
            adj.get(root.right.val).add(root.val);
            buildGraph(root.right);
        }
    }
}