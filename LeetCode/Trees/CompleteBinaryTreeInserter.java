///   https://leetcode.com/problems/complete-binary-tree-inserter/

class CBTInserter {
    private ArrayDeque<TreeNode> lastCompleteLevel ;
    private TreeNode root;


    public CBTInserter(TreeNode root) {
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        ArrayDeque<TreeNode> prev = new ArrayDeque<>();

        this.root = root;

        q.addLast(root);
        int level = 0;
        while(!q.isEmpty()){
            int levelSize = q.size();

            if(levelSize == (1 << level)) prev = (ArrayDeque<TreeNode>) q.clone();
            else break;

            while(levelSize-- > 0){
                var top = q.removeFirst();
                if(top.left != null) q.addLast(top.left);
                if(top.right != null) q.addLast(top.right);
            }

            level++;
        }

        lastCompleteLevel = prev;
    }


    public int insert(int val) {
        int parent = -1;

        for(var node : lastCompleteLevel){
            if(node.left == null) {
                parent = node.val;
                node.left = new TreeNode(val);
                break;
            }
            else if(node.right == null){
                parent = node.val;
                node.right = new TreeNode(val);
                break;
            }
        }

        if(parent == -1){
            ArrayDeque<TreeNode> newDeq = new ArrayDeque<>();
            for(var node : lastCompleteLevel) {
                newDeq.add(node.left);
                newDeq.add(node.right);
            }
            
            lastCompleteLevel = newDeq;
            parent = lastCompleteLevel.getFirst().val; 
            lastCompleteLevel.getFirst().left = new TreeNode(val);   
        }
        
        return parent;
    }

    public TreeNode get_root() {
        return root;
    }
}