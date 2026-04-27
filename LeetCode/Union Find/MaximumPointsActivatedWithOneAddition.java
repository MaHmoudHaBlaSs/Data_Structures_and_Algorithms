/// https://leetcode.com/problems/maximum-points-activated-with-one-addition/description/


class Solution {
    public int maxActivated(int[][] points) {
        HashMap<Integer, Integer> xMap = new HashMap<>(), yMap = new HashMap<>();

        for (int i = 0; i < points.length; i++) {
            xMap.put(Integer.valueOf(points[i][0]), Integer.valueOf(i));
            yMap.put(Integer.valueOf(points[i][1]), Integer.valueOf(i));
        }
        
        UnionFind uf = new UnionFind(points.length);
        for (int i = 0; i < points.length; i++) {
            int x = points[i][0], y = points[i][1]; 
            uf.union(i, xMap.get(Integer.valueOf(x)));
            uf.union(i, yMap.get(Integer.valueOf(y)));
        }
        
        HashMap<Integer, Integer> parents = uf.getParents();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int len : parents.values()) {
            pq.add(Integer.valueOf(len)); 
            if(pq.size() > 2) pq.poll();
        }
        
        int ans = 0;
        for (int len : pq) ans += len;
        
        return ans+1;
    }

    static class UnionFind {
        private int[] parent, size;

        public UnionFind(int n){
            parent = new int[n];
            size = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int p){
            if (p == parent[p]) return p;

            parent[p] = find(parent[p]);
            size[p] = size[parent[p]];
            return parent[p];
        }

        public boolean union(int p, int q){
            int rootP = find(p),  rootQ = find(q);

            if (rootP == rootQ) return false;

            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
            
            return true;
        }
        
        public HashMap<Integer, Integer> getParents(){
            HashMap<Integer, Integer> ans = new HashMap<>();
            for(int i=0; i<parent.length; ++i){
                ans.putIfAbsent(Integer.valueOf(find(i)), Integer.valueOf(size[i]));
            }
            
            return ans;
        }
    }
}