///  https://leetcode.com/problems/strange-printer-ii/description/


class Solution {
    public boolean isPrintable(int[][] targetGrid) {
        
        //1. get boundaries for each rectangle contains a specific color
        HashMap<Integer, int[]> boundaries = getBoundaries(targetGrid);
        var colors = boundaries.keySet();
        
        //2. construct a directed graph where color_i depends on color_j if the rectangle of color_i contains any cell with color_j
        HashMap<Integer, HashSet<Integer>> adj = new HashMap<>();
        for (int color : colors){
            adj.put(color, new HashSet<>());
        }

        for (int color : colors){
            int[] arr = boundaries.get(color);
            for (int i = arr[0]; i <= arr[1]; i++) {
                for (int j = arr[2]; j <= arr[3]; j++) {
                    if(targetGrid[i][j] != color)
                        adj.get(color).add(targetGrid[i][j]);
                }
            }
        }
        
        //3. if the graph is cyclic (there are two/more colors depend on each other), the grid can't be printed as wanted
        HashMap<Integer, Byte> status = new HashMap<>();
        
        for(int color : colors) status.put(color, UNVISITED);
        
        for (int color : colors) {
            if (status.get(color) == UNVISITED && isCyclic(color, adj, status))
                return false;
        }

        return true;
    }
    
    private HashMap<Integer, int[]> getBoundaries(int[][] targetGrid){
        HashMap<Integer, int[]> boundaries = new HashMap<>(); // value is [top, bottom, left, right]
        int n = targetGrid.length, m = targetGrid[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int color = targetGrid[i][j];

                if (!boundaries.containsKey(color)) boundaries.put(color, new int[]{i,i, j,j});

                int[] arr = boundaries.get(color);
                if (i < arr[0]) arr[0] = i;
                if (i > arr[1]) arr[1] = i;
                if (j < arr[2]) arr[2] = j;
                if (j > arr[3]) arr[3] = j;
            }
        }
        
        return boundaries;
    } 
    
    private final byte UNVISITED = 0, IN_PROGRESS = 1, VISITED = 2;
    
    private boolean isCyclic(int v, HashMap<Integer,HashSet<Integer>> adj, HashMap<Integer, Byte> status){
        status.put(v, IN_PROGRESS);

        for(int neb : adj.get(v)){
            if (status.get(neb) == IN_PROGRESS) {
                return true;
            }
            else if (status.get(neb) == UNVISITED){
                if (isCyclic(neb, adj, status))
                    return true;
            }
        }

        status.put(v, VISITED);
        return false;
    }
}