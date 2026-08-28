///  https://leetcode.com/problems/shortest-path-with-alternating-colors/description/

class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        ArrayList<Integer>[] blueAdj = new ArrayList[n], redAdj = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            blueAdj[i] = new ArrayList<>();
            redAdj[i] = new ArrayList<>();
        }

        for(int[] e : redEdges){
            redAdj[e[0]].add(e[1]);
        }
        for(int[] e : blueEdges){
            blueAdj[e[0]].add(e[1]);
        }

        int[] ans = new int[n];
        for (int i = 1; i < n; i++) {
            ans[i] = shortestPath(i, blueAdj, redAdj);
        }
        
        return ans;
    }

    private int shortestPath(int target, ArrayList<Integer>[] blueAdj, ArrayList<Integer>[] redAdj){
        boolean[] blueVis = new boolean[blueAdj.length], redVis = new boolean[blueVis.length];

        Queue<Pair<Integer, Boolean>> queue = new ArrayDeque<>();
        blueVis[0] = redVis[0] = true;
        queue.offer(Pair.of(0, true));
        queue.offer(Pair.of(0, false));

        int level = 0;
        while (!queue.isEmpty()){
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Pair<Integer, Boolean> top = queue.poll();
                if(top.getKey() == target) return level;

                boolean blue = top.getValue();
                if(blue){
                    for(int neb : redAdj[top.getKey()]){
                        if(!redVis[neb]){
                            queue.offer(Pair.of(neb, false));
                            redVis[neb] = true;
                        }
                    }
                }else{
                    for(int neb : blueAdj[top.getKey()]){
                        if(!blueVis[neb]){
                            queue.offer(Pair.of(neb, true));
                            blueVis[neb] = true;
                        }
                    }          
                }
            }
            
            level++;
        }
        
        return -1;
    }

    static class Pair<K,V>{
        private K key;
        private V value;

        private Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public static <K,V> Pair<K,V> of(K key, V value){
            return new Pair<>(key, value);
        }

        @Override
        public int hashCode() {
            return key.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            return key.equals(((Pair<?, ?>)obj).key);
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

}