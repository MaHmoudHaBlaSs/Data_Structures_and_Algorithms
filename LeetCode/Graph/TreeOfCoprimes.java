///  https://leetcode.com/problems/tree-of-coprimes/description/

class Solution {
    private int[] ans, nums;
    private ArrayList<ArrayList<Integer>> adj ;

    private void dfs(int u, ArrayList<Entry> numNodeList, boolean[] vis) {
        vis[u] = true;

        for(var entry : numNodeList) {
            if(areCoPrimes(nums[u], entry.num))
                ans[u] = entry.node;
        }

        //remove the occurrence of nums[u]
        Iterator<Entry> it = numNodeList.iterator();
        Entry removed = null; int removedIndex = -1;
        while(it.hasNext()){
            removedIndex++;
            Entry entry = it.next();
            if(entry.num != nums[u]) continue;
            
            removed = entry;
            it.remove();
            break;
        }
        
        numNodeList.add(new Entry(nums[u], u));

        for (int neb : adj.get(u)) {
            if (!vis[neb])
                dfs(neb, numNodeList, vis);
        }

        it = numNodeList.iterator();
        while(it.hasNext()){
            Entry entry = it.next();
            if(entry.num != nums[u]) continue;

            it.remove();
            break;
        }
        
        if(removed != null)
            numNodeList.add(removedIndex, removed);
    }

    private boolean areCoPrimes(int a, int b){
        while(b != 0){
            int rem = a % b;
            a = b;
            b = rem;
        }
        return a == 1;
    }

    public int[] getCoprimes(int[] nums, int[][] edges) {
        int n = nums.length;
        ans = new int[n]; this.nums = nums; adj = new ArrayList<>(n);
        Arrays.fill(ans, -1);

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        dfs(0, new ArrayList<>(), new boolean[n]);

        return ans;
    }

    private static class Entry  {
        int num, node;

        public Entry(int num, int node) {
            this.node = node;
            this.num = num;
        }
    }
}