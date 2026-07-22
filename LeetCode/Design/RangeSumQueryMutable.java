https://leetcode.com/problems/range-sum-query-mutable

// Best implementation of Segment Tree (+simple)
class NumArray {

    // Sum segment tree (built like heap)
    int[] segmentTree;
    int n;
    public NumArray(int[] nums) {
        n = nums.length;
        segmentTree = new int[n * 2]; 
        System.arraycopy(nums, 0, segmentTree, n, n);
        
        for ( int i = n-1; i > 0; i--){
            segmentTree[i] = segmentTree[i * 2] + segmentTree[i * 2 + 1];
        }
    }
    
    public void update(int rawInd, int val) {
        int ind = rawInd + n;
        if ( segmentTree[ind] == val ) return;

        segmentTree[ind] = val;
        ind /= 2; // go to parent

        while ( ind > 0 ){
            segmentTree[ind] = segmentTree[ind * 2] + segmentTree[ind * 2 + 1];
            ind /= 2;
        }
    }
    
    public int sumRange(int left, int right) {
        int from = left + n;
        int to = right + n;
        int sum = 0;
        
        while ( from <= to ){
            if ( from % 2 == 1 ){
                sum += segmentTree[from];
                from++;
            }
            if ( to % 2 == 0 ){
                sum += segmentTree[to];
                to--;
            }
            from /= 2;
            to /= 2;
        }

        return sum;
    }
}

// Bad implementation of segment tree using node (+complex)
class NumArray {
    static class Node {
        int[] bounds;
        int sum;
        Node left;
        Node right;

        public Node(int left, int right){
            bounds = new int[]{left, right};
        }
    }

    Node root;
    int[] array;
    public NumArray(int[] nums) {
        array = nums.clone();
        root = build(0, nums.length-1);
    }

    // Divide and Conquer technique like merge sort (builds tree)
    private Node build(int left, int right){
        Node node = new Node(left, right);
        if ( left != right){
            int mid = (left + right) / 2;
            node.left = build(left, mid);
            node.right = build(mid+1, right);
            node.sum = node.left.sum + node.right.sum;
        }
        else
            node.sum = array[left];

        return node;
    }

    public void update(int index, int val) {
        recurUpdate(index, val, root);
        array[index] = val;
    }
    private void recurUpdate(int index, int val, Node node){
        if ( node.bounds[0] == node.bounds[1]) {
            node.sum = val;
            return;
        }

        int mid = (node.bounds[0] + node.bounds[1])/2;
        if ( index <= mid)
            recurUpdate(index, val, node.left);
        else
            recurUpdate(index, val, node.right);

        node.sum = node.left.sum + node.right.sum;
    }

    public int sumRange(int left, int right) {
        return recurSumRange(left, right, root);
    }

    private int recurSumRange(int left, int right, Node node){
        // Base Case
        if ( left == node.bounds[0] && right == node.bounds[1])
            return node.sum;


        int mid = (node.bounds[0] + node.bounds[1]) / 2;
        int leftSum = 0;
        int rightSum = 0;

        if ( right <= mid) // Range is in left tree
            leftSum = recurSumRange(left, right, node.left);

        else{
            if ( left > mid ) // Range is in right tree
                rightSum = recurSumRange(left, right, node.right);

            else{ // Overlap (left <= mid && right > mid)
                leftSum = recurSumRange(left, mid, node.left);
                rightSum = recurSumRange(mid+1, right, node.right);
            }
        }
        return leftSum + rightSum;
    }
}