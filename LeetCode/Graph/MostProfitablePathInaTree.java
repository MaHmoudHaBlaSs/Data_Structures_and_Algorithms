///  https://leetcode.com/problems/most-profitable-path-in-a-tree/description/

class Solution {
    private List<ArrayList<Integer>> adj ;
    private int[] bobTimes, amount;

    private boolean canGetZero(int start, boolean[] vis, int time){
        vis[start] = true;

        if(start == 0) {
            bobTimes[0] = time;
            return true;
        }

        for(int neb : adj.get(start)){
            if(!vis[neb] && canGetZero(neb,vis,time+1)){
                bobTimes[start] = time;
                return true;
            }
        }

        return false;
    }

    private int getMaxProfitUntilLeaf(int start, boolean[] vis, int time){
        vis[start] = true;
        int bobTime = bobTimes[start];

        int profit = time < bobTime || bobTime == -1 ? amount[start] : 
            time == bobTimes[start] ? amount[start] / 2 : 0;
        if(isLeaf(start)) return profit;

        int maxNeighbor = Integer.MIN_VALUE;
        for(int neb : adj.get(start)){
            if(!vis[neb]){
                maxNeighbor = Math.max(maxNeighbor, getMaxProfitUntilLeaf(neb,vis,time+1));
            }
        }

        return profit + maxNeighbor;
    }

    private boolean isLeaf(int node){
        return node != 0 && adj.get(node).size() == 1;
    }

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;
        adj = new ArrayList<>(n);
        bobTimes = new int[n];
        this.amount = amount;

        for (int i = 0; i < n; i++) {
            bobTimes[i] = -1;
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        canGetZero(bob,new boolean[n], 0);

        return getMaxProfitUntilLeaf(0,new boolean[n], 0);
    }
}