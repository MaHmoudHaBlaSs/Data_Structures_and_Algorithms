/// https://leetcode.com/problems/minimize-hamming-distance-after-swap-operations/description/

class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length, ans = 0;

        ArrayList<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for (int[] p : allowedSwaps) {
            adj[p[0]].add(p[1]);
            adj[p[1]].add(p[0]);
        }

        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;

            List<Integer> component = nodeComponent(i, adj, visited);
            HashMap<Integer, Integer> freq = new HashMap<>();

            for (int idx : component) {
                freq.put(source[idx], freq.getOrDefault(source[idx], 0) + 1);
                freq.put(target[idx], freq.getOrDefault(target[idx], 0) - 1);
            }

            int diff = 0;
            for (int v : freq.values()) {
                diff += Math.abs(v);
            }

            ans += diff >> 1;
        }

        return ans;
    }

    private List<Integer> nodeComponent(int start, ArrayList<Integer>[] adj, boolean[] visited) {
        List<Integer> comp = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();

        stack.push(start);
        visited[start] = true;

        while (!stack.isEmpty()) {
            int v = stack.pop();
            comp.add(v);

            for (int nei : adj[v]) {
                if (!visited[nei]) {
                    visited[nei] = true;
                    stack.push(nei);
                }
            }
        }

        return comp;
    }
}