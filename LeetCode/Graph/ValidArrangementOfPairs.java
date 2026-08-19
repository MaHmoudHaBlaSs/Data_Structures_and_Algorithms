/// https://leetcode.com/problems/valid-arrangement-of-pairs/description/

class Solution {
    public int[][] validArrangement(int[][] pairs) {
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        HashMap<Integer, Integer> inDegree = new HashMap<>(), outDegree = new HashMap<>();
        
        for(int[] pair : pairs){
            adj.computeIfAbsent(pair[0], (k) -> new ArrayList<>()).add(pair[1]);
            outDegree.put(pair[0], outDegree.getOrDefault(pair[0], 0)+1);
            inDegree.put(pair[1], inDegree.getOrDefault(pair[1], 0)+1);
        }
        
        int start = pairs[0][0];
        for(var entry : outDegree.entrySet()){
            if(entry.getValue() - inDegree.getOrDefault(entry.getKey(),0) == 1)
                start = entry.getKey();
        }

        ArrayList<Integer> path = new ArrayList<>(pairs.length << 1);
        dfs(start, adj, path);
        Collections.reverse(path);
        
        int j = 0;
        for (int i = 0; i < pairs.length; i++) {
            pairs[i][0] = path.get(j++);
            pairs[i][1] = path.get(j);
        }
        
        return pairs;
    }
    
    private void dfs(int u, Map<Integer, List<Integer>> adj, List<Integer> path) {
        while (!adj.getOrDefault(u, Collections.emptyList()).isEmpty()) {
            int v = adj.get(u).remove(adj.get(u).size() - 1);
            dfs(v, adj, path);
        }

        path.add(u);
    }

}