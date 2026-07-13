///  https://leetcode.com/problems/maximize-alternating-sum-using-swaps/description/


class Solution {
    public long maxAlternatingSum(int[] nums, int[][] swaps) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        HashMap<Integer, Integer> evenCount = new HashMap<>();

        UnionFind uf = new UnionFind(nums.length);
        for(int[] swap : swaps){
            uf.union(swap[0], swap[1]);
        }

        long evenSum = 0, oddSum = 0;
        for(int i=0; i<nums.length; i++){
            int parent = uf.find(i);

            if(!map.containsKey(parent)){
                map.put(parent, new ArrayList<>());
            }

            map.get(parent).add(i);

            if((i&1) == 0){
                evenCount.put(parent, evenCount.getOrDefault(parent, 0) + 1);
            }
        }

        for(var entry : map.entrySet()){
            entry.getValue().sort((a, b) -> nums[b] - nums[a]);

            int c = evenCount.getOrDefault(entry.getKey(),0);
            
            for(int i=0; i<c; ++i){
                evenSum += nums[entry.getValue().get(i)];
            }
            
            for(int i=c; i<entry.getValue().size(); ++i){
                oddSum += nums[entry.getValue().get(i)];
            }
        }
        
        return evenSum - oddSum;
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