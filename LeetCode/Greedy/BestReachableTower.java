///   https://leetcode.com/problems/best-reachable-tower/description/

class Solution {
    public int[] bestTower(int[][] towers, int[] center, int radius) {
        int[] best = {-1,-1,-1};
        
        for(int[] tower: towers){
            int dist = Math.abs(tower[0]-center[0]) + Math.abs(tower[1]-center[1]);
            if(dist > radius) continue;

            if(best[2] < tower[2] || 
                (best[2] == tower[2] && lexicographicallySmaller(tower, best))){
                best = tower;
            } 
        }

        return new int[]{best[0], best[1]};
    }

    private boolean lexicographicallySmaller(int[] a, int[] b){
        if(a[0] < b[0]) return true;
        if(a[0] > b[0]) return false;

        return a[1] < b[1]; 
    }
}