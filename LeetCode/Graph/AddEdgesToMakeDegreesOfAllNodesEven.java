// https://leetcode.com/problems/add-edges-to-make-degrees-of-all-nodes-even

class Solution {

    public record Edge(int u, int v) {
        public Edge {
            if (u > v) {
                int tmp = u;
                u = v;
                v = tmp;
            }
        }
    }

    public boolean isPossible(int n, List<List<Integer>> inEdges) {
        Set<Edge> edges = new HashSet<>();
        int[] nodes = new int[n+1];

    
        for (List<Integer> edge: inEdges){
            int u = edge.get(0); int v = edge.get(1);
            edges.add( new Edge(u, v) );
            nodes[u]++; nodes[v]++;
        }

        List<Integer> odds = new LinkedList<>();
        for (int i = 1; i < nodes.length; i++){
            if ( nodes[i] % 2 != 0 )
                odds.add(i);
        }

        if ( odds.isEmpty() ) return true;
        else if ( odds.size() % 2 != 0 ) return false;
        else if ( odds.size() > 4) return false;

        // We only consider size of 2 or 4.
        if ( odds.size() == 2){
            int a = odds.get(0), b = odds.get(1);

            if ( edges.contains(new Edge(a, b)) ) {
                for (int i = 1; i < nodes.length; i++){
                    if (i != a && i != b && 
                    !edges.contains(new Edge(a, i)) && !edges.contains(new Edge(b, i)))
                        return true;
                }
                return false;
            }
            return true;
        }
        else {
            int a = odds.get(0), b = odds.get(1);
            int c = odds.get(2), d = odds.get(3);

            if (!edges.contains(new Edge(a, b)) && !edges.contains(new Edge(c, d))) return true;
            if (!edges.contains(new Edge(a, c)) && !edges.contains(new Edge(b, d))) return true;
            if (!edges.contains(new Edge(a, d)) && !edges.contains(new Edge(b, c))) return true;

            return false;
        }
    }
}