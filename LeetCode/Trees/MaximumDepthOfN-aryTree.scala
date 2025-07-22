object Solution {
    var max = 0

    def maxDepth(root: Node): Int = {
        if (root == null) return 0

        max = 0
        dfs(root, 1)
        return max
    }

    def dfs(node: Node, depth: Int): Unit = {
        if (node.children.isEmpty)
            max = Math.max(depth, max)
        else{
            for (child <- node.children)
                dfs(child, depth+1)
        }
    }
}