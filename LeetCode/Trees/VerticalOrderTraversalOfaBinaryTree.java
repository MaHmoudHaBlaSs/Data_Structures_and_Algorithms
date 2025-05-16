///  https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/description/


//Time: O(n.log(n))   Space: O(n)
class Solution {
    private List<Node> nodes = new ArrayList<>();
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        traverse(root,0,0);
        
        Collections.sort(nodes);

        List<List<Integer>> ans = new ArrayList<>();
        var last = new ArrayList<Integer>();
        last.add(nodes.get(0).data);
        
        for(int i=1; i<nodes.size(); i++){
            var node =  nodes.get(i);
            
            if(nodes.get(i-1).col != node.col) {
                ans.add(last);
                last = new ArrayList<Integer>();
            }
            
            last.add(node.data);
        }
        
        ans.add(last);
        return ans;
    }
    
    private void traverse(TreeNode root,int row, int col){
        if(root == null) return;
        
        traverse(root.left, row+1, col-1);
        nodes.add(new Node(row, col, root.val));
        traverse(root.right, row+1, col+1);
    }

    private class Node implements Comparable<Node> {
        int row,col,data;

        public Node(int row, int col, int data) {
            this.row = row;
            this.col = col;
            this.data = data;
        }

        @Override
        public int compareTo(Node o) {
            if (col != o.col) 
                return this.col - o.col;
            
            if(row != o.row) 
                return this.row - o.row;
            
            return data - o.data;
        }
    }
}