///  https://leetcode.com/problems/maximum-partition-factor/description/

class Solution {
    public int maxPartitionFactor(int[][] points) {
        int maxDist = 0, minDist = Integer.MAX_VALUE;
        int n = points.length;
        
        if (n == 2) return 0;
        
        for(int i=0; i<n; ++i){
            for(int j=i+1; j<n; ++j){
                int curr = manhattan(points[i], points[j]);

                if(curr > maxDist) maxDist = curr;
                if(minDist > curr) minDist = curr;
            }
        }

        int ans = 0, left = minDist, right = maxDist;
        while(left <= right){
            int mid = (left+right) >> 1;

            if(canSplit(points, mid)){
                ans = mid;
                left = mid + 1;
            }
            else right = mid-1;
        }

        return ans;
    }

    private boolean canSplit(int[][] points, int dist){
        ArrayList<Integer>[] adj = new ArrayList[points.length];

        for(int i=0; i<points.length; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i=0; i<points.length; ++i){
            for(int j=i+1; j<points.length; ++j){
                if(manhattan(points[i], points[j]) < dist){
                    adj[i].add(j);
                    adj[j].add(i);
                }
            }
        }


        return isBipartite(adj);
    }


    private boolean isBipartite(ArrayList<Integer>[] adj){
        int n = adj.length;
        boolean[] visited = new boolean[n], color = new boolean[n];
        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<n; ++i){
            if(visited[i]) continue;

            visited[i] = true; color[i] = true;
            q.add(i);

            while(!q.isEmpty()){
                int v = q.poll();

                for(int neb : adj[v]){
                    if(!visited[neb]){
                        visited[neb] = true;
                        color[neb] = !color[v];
                        q.add(neb);
                    }
                    else if(color[v] == color[neb])
                        return false;
                }
            }
        }


        return true;
    }

    private int manhattan(int[] i, int[] j){
        return Math.abs(i[0]-j[0]) + Math.abs(i[1]-j[1]);
    }
}