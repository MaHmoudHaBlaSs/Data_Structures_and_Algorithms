///  https://leetcode.com/problems/make-lexicographically-smallest-array-by-swapping-elements/description/

class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        int[][] arr = new int[n][2];
        for(int i=0; i<n; ++i) arr[i] = new int[]{i,nums[i]};

        Arrays.sort(arr, (a,b) -> a[1] - b[1]);
        UnionFind uf = new UnionFind(n);

        for(int i=1; i<n; ++i){
            if(arr[i][1] - arr[i-1][1] <= limit) 
                uf.union(arr[i][0],arr[i-1][0]);
        }

        HashMap<Integer, PriorityQueue<Integer>> mp = new HashMap<>();
        for(int i=0; i<n; ++i){
            int p = uf.find(i);
            var pq = mp.computeIfAbsent(p,(a)-> new PriorityQueue());
            pq.offer(nums[i]);
        }


        for(int i=0; i<n; ++i){
            int p = uf.find(i);
            nums[i] = mp.get(p).poll(); 
        }

        return nums;
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