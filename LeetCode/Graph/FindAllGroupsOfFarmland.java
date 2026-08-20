// https://leetcode.com/problems/find-all-groups-of-farmland/description/

class Solution {
    public int[][] findFarmland(int[][] land) {
        boolean[][] visited = new boolean[land.length][land[0].length];
        List<int[]> list = new ArrayList<>();
        for(    int i = 0 ; i < land.length ; i++){
            for(int j = 0 ; j < land[0].length ; j++){
                if(land[i][j] == 1 && !visited[i][j]){
                    int[] farmland = bfsFarmland(land, visited, i, j);
                    list.add(farmland);
                }
            }
        }
        return list.toArray(new int[list.size()][]);
    }
    public int[] bfsFarmland(int[][] land, boolean[][] visited, int i, int j) {
        int[] farmland = new int[4];
        farmland[0] = i;
        farmland[1] = j;
        farmland[2] = i;
        farmland[3] = j;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];

            // Update the bottom-right corner of the farmland
            farmland[2] = Math.max(farmland[2], row);
            farmland[3] = Math.max(farmland[3], col);

            if (row + 1 < land.length && land[row + 1][col] == 1 && !visited[row + 1][col]) {
                queue.offer(new int[]{row + 1, col});
                visited[row + 1][col] = true;
            }
            if (col + 1 < land[0].length && land[row][col + 1] == 1 && !visited[row][col + 1]) {
                queue.offer(new int[]{row, col + 1});
                visited[row][col + 1] = true;
            }
        }

        return farmland;
    }
}