///  https://leetcode.com/problems/logical-or-of-two-binary-grids-represented-as-quad-trees/description/

class Solution {
    public Node intersect(Node quadTree1, Node quadTree2) {
        if (quadTree1.isLeaf) {
            if (quadTree1.val) return new Node(true, true, null, null, null, null);
            return quadTree2;
        }
        if (quadTree2.isLeaf) {
            if (quadTree2.val) return new Node(true, true, null, null, null, null);
            return quadTree1;
        }

        Node res = new Node();
        res.topLeft = intersect(quadTree1.topLeft, quadTree2.topLeft);
        res.topRight = intersect(quadTree1.topRight, quadTree2.topRight);
        res.bottomLeft = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
        res.bottomRight = intersect(quadTree1.bottomRight, quadTree2.bottomRight);

        if (res.topLeft.isLeaf && res.topRight.isLeaf && res.bottomLeft.isLeaf && res.bottomRight.isLeaf) {
            if (res.topLeft.val == res.topRight.val &&
                res.topLeft.val == res.bottomLeft.val &&
                res.topLeft.val == res.bottomRight.val) {
                return new Node(res.topLeft.val, true, null, null, null, null);
            }
        }
        return res;
    }
}