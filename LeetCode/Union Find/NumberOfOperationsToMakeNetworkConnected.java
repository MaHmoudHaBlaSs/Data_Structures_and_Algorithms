
// https://leetcode.com/problems/number-of-operations-to-make-network-connected

// T: O(n)        S: O(n)
class Solution {
    Map<Integer, Integer> subGraphs = new HashMap<>();
    int discoveredNodes = 0;

    public int makeConnected(int n, int[][] connections) {
        int cycles = 0, innerConnections = 0;

        for (int[] connection: connections){
            int p1 = getParent(connection[0]);
            int p2 = getParent(connection[1]);
            int p1Val = subGraphs.get(p1), p2Val = subGraphs.get(p2);

            if (p1 == p2)
                cycles++;
            else if (p1Val <= p2Val){
                subGraphs.put(p1, p1Val + p2Val);
                subGraphs.put(p2, p1);
                innerConnections++;
            }
            else{
                subGraphs.put(p2, p1Val + p2Val);
                subGraphs.put(p1, p2);
                innerConnections++;
            }
        }

        // Edges required to connect all nodes with no cycles are exctly n-1
        int diff = (n - discoveredNodes) + (discoveredNodes-1 - innerConnections);
        return (cycles >= diff)? diff: -1;
    }

    public int getParent(int i){
        if (!subGraphs.containsKey(i)){
            subGraphs.put(i, -1); // New node 
            discoveredNodes++;
        }

        while (subGraphs.get(i) > -1)
            i = subGraphs.get(i); // Go to parent
        return i;
    }
}