///   https://leetcode.com/problems/all-possible-full-binary-trees/

class Solution {
    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> ans = new ArrayList<>();

        if(n % 2 == 0) return ans; 

        if(n==1) {
            ans.add(new TreeNode()); 
        }
        
        for(int i=1; i<n;i+=2){
            var leftList = allPossibleFBT(i);
            var rightList = allPossibleFBT(n-i-1);

            for(TreeNode leftNode : leftList){
                for(TreeNode rightNode : rightList){
                    ans.add(new TreeNode(0,leftNode,rightNode));
                }
            }
        }

        return ans; 
    }
}