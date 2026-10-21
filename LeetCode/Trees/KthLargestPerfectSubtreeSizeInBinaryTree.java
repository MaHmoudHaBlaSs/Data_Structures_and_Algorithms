///  https://leetcode.com/problems/k-th-largest-perfect-subtree-size-in-binary-tree/description/

class Solution {
    private ArrayList<Integer> sizes = new ArrayList<>(); 

    public int kthLargestPerfectSubtree(TreeNode root, int k) {
        perfectLevels(root);

        if(k > sizes.size()) return -1;

        Collections.sort(sizes, (a,b) -> b-a);
        return sizes.get(k-1);
    }

    private int perfectLevels(TreeNode root){
        if(root == null) return -1;

        if(root.left == null && root.right == null){ 
            sizes.add(1);
            return 1;
        }

        int l = perfectLevels(root.left) , r=perfectLevels(root.right);
        
        if(l == -1 || r==-1 || l != r) return -1;

        
        int count = l+1; 
        sizes.add((1<<count)-1);

        return count;
    }
}