// https://leetcode.com/problems/redundant-connection

// Disjoint Sets - Union Find
class Solution {
    Map<Integer, Integer> subGraphs = new HashMap<>();

    public int[] findRedundantConnection(int[][] edges) {
        int[] execluded = new int[2];

        for (int[] edge: edges){
            int p1 = getParent(edge[0], subGraphs);
            int p2 = getParent(edge[1], subGraphs);
            int p1Value = subGraphs.get(p1), p2Value = subGraphs.get(p2);

            if (p1 == p2)
                execluded = edge;

            else if (p1Value >= p2Value){
                subGraphs.put(p1, subGraphs.get(p1) + subGraphs.get(p2));
                subGraphs.put(p2, p1);
            }
            else{
                subGraphs.put(p2, subGraphs.get(p1) + subGraphs.get(p2));
                subGraphs.put(p1, p2);
            }
        }
        return execluded;
    }
    public int getParent(int i, Map<Integer, Integer> subGraphs){
        while (subGraphs.get(i) != null && subGraphs.get(i) > 0)
            i = subGraphs.get(i);

        if (subGraphs.get(i) == null)
            subGraphs.put(i, -1);

        return i;
    }
}