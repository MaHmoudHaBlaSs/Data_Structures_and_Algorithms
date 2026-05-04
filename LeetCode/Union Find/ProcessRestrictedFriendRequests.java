/// https://leetcode.com/problems/process-restricted-friend-requests/description/


class Solution {
    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        UnionFind uf = new UnionFind(n);
        boolean[] arr = new boolean[requests.length]; 
        
        for(int i=0; i<requests.length; ++i){
            int u = requests[i][0], v = requests[i][1];
            int rootU = uf.find(u), rootV = uf.find(v); 
            
            arr[i] = true;  
            if(rootV==rootU) continue;
            
            for(int[] res : restrictions){
                int rootX = uf.find(res[0]), rootY = uf.find(res[1]); 
                if((rootX==rootU && rootY==rootV) || (rootX==rootV && rootY==rootU)){
                    arr[i] = false;
                    break;
                }
            }
            
            if(arr[i]) uf.union(u,v);
        }
        
        return arr;
    }
    
    static class UnionFind {
        private final int[] parent;

        public UnionFind(int n){
            parent = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int p){
            if (p == parent[p]) return p;

            parent[p] = find(parent[p]);
            return parent[p];
        }

        public boolean union(int p, int q){
            int rootP = find(p),  rootQ = find(q);

            if (rootP == rootQ) return false;

            parent[rootP] = rootQ;
            return true;
        }
    }
}