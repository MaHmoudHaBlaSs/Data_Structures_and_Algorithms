
/* 
Flip if there is a node on the left while the needed one on the right
*/

class Solution {
    private int[] arr;
    private int i=0;
    private List<Integer> ans = new ArrayList<>(); 
    
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        arr = voyage; 

        if(!canMatch(root)){ 
            ans.clear();
            ans.add(-1); 
        }

        return ans; 
    }

    private boolean canMatch(TreeNode root){
        if(root == null) return true;

        if(root.val != arr[i]) return false;
        
        if(++i >= arr.length) return true;

        if(root.left != null && root.right != null && root.right.val == arr[i]){
            ans.add(root.val);
            return (canMatch(root.right) && canMatch(root.left));
        } 

        return (canMatch(root.left) && canMatch(root.right));
    }
}