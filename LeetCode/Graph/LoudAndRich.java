///  https://leetcode.com/problems/loud-and-rich/


/*
1-each person is neeeds to know about the richer persons so it's a directed graph from person -to-> richerPersons
2-ans[person] = the person with min (quiet[ans[person]], quiet[ans[each neighbor to that person]]) 
*/

//Time: O(V+E)       Space: O(V+E)
class Solution {
    private ArrayList<Integer>[] adj;
    private int[] ans,quiet; 

    private void DFS(int person){
        if(ans[person] != -1) 
            return; 

        ans[person] = person; 

        if(adj[person] == null) 
            return; 

        for(int neighbor : adj[person]){
            if(ans[neighbor] == -1) 
                DFS(neighbor); 

            ans[person] = quiet[ans[neighbor]] < quiet[ans[person]] ? ans[neighbor] : ans[person]; 
        }
    }

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        adj = new ArrayList[n]; 
        ans = new int[n]; 
        this.quiet=  quiet;

        Arrays.fill(ans,-1); 

        for(int[] edge : richer){
            if(adj[edge[1]] == null) 
                adj[edge[1]] = new ArrayList<>(); 

            adj[edge[1]].add(edge[0]); 
        }

        for(int i=0; i<n; i++){
            if(ans[i] == -1) 
                DFS(i);
        }

        return ans;     
    }
}