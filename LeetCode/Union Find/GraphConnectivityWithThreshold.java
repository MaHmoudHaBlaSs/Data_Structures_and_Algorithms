///  https://leetcode.com/problems/graph-connectivity-with-threshold/description/

/*
Brute force is to use nested loops and check the gcd of every pair of numbers between 1 to n.
The trick is that:
    if gcd(a,b) = a then the number b is any multiple of a. 
    so put a with numbers form 1 to n, and set an edge between a and any multiple of a <= n.
*/

//Time: O(N.Log(N) + Q) 
class Solution {    
    private int[] parent;

    private int find(int node){
        if(parent[node] != node)  
            parent[node] = find(parent[node]);

        return parent[node];
    }

    private void union(int u, int x){
        int uParent =  find(u);
        int xParent =  find(x);

        if(uParent != xParent) parent[uParent] = xParent;
    }

    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        parent = new int[n+1];
        for(int i=1; i<=n; i++) parent[i] = i;

        for(int i=threshold+1; i<n; i++){
            for(int j=1; j*i <= n;j++) 
                union(i, i*j);
        }

        List<Boolean> res = new ArrayList<>();
        for(int i=0; i<queries.length; i++){
            if(find(queries[i][0]) == find(queries[i][1])) res.add(true);
            else res.add(false);
        }

        return res; 
    }
}