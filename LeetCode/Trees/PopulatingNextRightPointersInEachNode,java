// https://leetcode.com/problems/populating-next-right-pointers-in-each-node

// BFS
class Solution {
    public Node connect(Node root) {
        if (root == null) return root;
        Node temp = root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(temp);

        while (!queue.isEmpty()){
            for(int i = queue.size(); i > 0; i--){
                Node polled = queue.poll();

                if (i > 1)
                    polled.next = queue.peek();
                
                if (polled.left != null) queue.add(polled.left);
                if (polled.right != null) queue.add(polled.right);
            } 
        }
        return root;
    }
}