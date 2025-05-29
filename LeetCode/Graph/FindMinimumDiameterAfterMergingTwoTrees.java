/// https://leetcode.com/problems/find-minimum-diameter-after-merging-two-trees/description/

/*
Get the tree diameter: 
    1-Start from any vertex and get the furthestNode from it
	2-From furthestNode, traverse again to get the longest path length which is the distance from furthestNode to a new furthest node
	DFS can be used easily here.

Ans is max(d1, d2 , ceil(d1/2)+ceil(d2/2)+1)
*/

class Solution {
    private int furthestNode, distanceOfFurthestNode;
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        ArrayList<Integer>[] tree1, tree2;
        tree1 = new ArrayList[edges1.length+1];
        tree2 = new ArrayList[edges2.length+1];
        
        for(var edge : edges1) {
            if(tree1[edge[0]] == null) tree1[edge[0]] = new ArrayList<>();
            if(tree1[edge[1]] == null) tree1[edge[1]] = new ArrayList<>();
            
            tree1[edge[0]].add(edge[1]);
            tree1[edge[1]].add(edge[0]);
        }        
        
        for(var edge : edges2) {
            if(tree2[edge[0]] == null) tree2[edge[0]] = new ArrayList<>();
            if(tree2[edge[1]] == null) tree2[edge[1]] = new ArrayList<>();
            
            tree2[edge[0]].add(edge[1]);
            tree2[edge[1]].add(edge[0]);
        }
        
        int d1 = diameter(tree1) , d2  = diameter(tree2);
        return Math.max( ((d1 + 1) / 2) + ((d2 + 1) / 2) + 1, Math.max(d1, d2));
    }

    private int diameter(ArrayList<Integer>[] tree){
        if(tree.length == 1) return 0;
        furthestNode = distanceOfFurthestNode = 0;
        dfs(1,0, new boolean[tree.length], tree);
        
        distanceOfFurthestNode = 0;
        dfs(furthestNode,0, new boolean[tree.length], tree);
        
        return distanceOfFurthestNode; 
    }

    private void dfs(int u, int depth, boolean[] vis, ArrayList<Integer>[] tree){
        vis[u] = true;

        if(depth > distanceOfFurthestNode) {
            distanceOfFurthestNode = depth;
            furthestNode = u;
        }

        int nextDepth = depth + 1;
        for(int neb : tree[u])
            if(!vis[neb]) dfs(neb, nextDepth, vis, tree);
    }
}