///  https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/description/


class Solution {
    public int pseudoPalindromicPaths (TreeNode root) {
        return dfs(root, new int[11]);
    }

    private int dfs(TreeNode root, int[] freq){
        if(root == null) return 0;

        freq[root.val]++;
        int ans = 0; 

        if(root.left == null && root.right == null){
            int odd = 0;
            for(int i=1; i<10; ++i){
                if((freq[i]&1) != 0) ++odd; 
            }

            ans = odd < 2? 1 : 0;
        }
        else{
            ans = dfs(root.left, freq) + dfs(root.right, freq);
        }
        
        freq[root.val]--;
        return ans;
    } 
}
