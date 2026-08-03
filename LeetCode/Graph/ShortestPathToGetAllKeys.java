///  https://leetcode.com/problems/shortest-path-to-get-all-keys/description/


class Solution {
    public int shortestPathAllKeys(String[] grid) {
        int m = grid.length, n = grid[0].length();
        int startI = -1, startJ = -1, keys = 0;

        for(int i=0; i<m; ++i){
            String st = grid[i];
            for(int j=0; j<n; ++j){
                char ch = st.charAt(j);
                if(ch == '@'){
                    startI = i;
                    startJ = j;
                }else if(Character.isLowerCase(ch)) keys++;
            }
        } 


        int finalMask = (1 << keys) - 1;

        boolean[][][] vis = new boolean[1 << keys][m][n];
        Queue<int[]> q = new ArrayDeque<>();

        int[] init = {0, startI, startJ};
        q.offer(init);
        vis[0][startI][startJ] = true;

        int[][] dirs = {{0,1}, {0,-1}, {-1,0}, {1,0}}; 
        int ans = 0;

        while(!q.isEmpty()){
            int levelSize = q.size();

            while(levelSize-- > 0){
                int[] curr = q.poll();
                if(curr[0] == finalMask) return ans;

                for(int[] dir : dirs){
                    int i = curr[1] + dir[0], j = curr[2] + dir[1], mask = curr[0];

                    if(i < 0 || i >= m || j < 0 || j >= n)
                        continue;

                    char c = grid[i].charAt(j);
                    if(c == '#') continue;

                    if(Character.isLowerCase(c)){
                        mask |= (1 << (c-'a'));
                    }else if(Character.isUpperCase(c)){
                        if(((mask >> (c-'A')) & 1) == 0) 
                            continue; 
                    }

                    if(!vis[mask][i][j]){
                        q.offer(new int[] {mask, i, j});
                        vis[mask][i][j] = true;
                    }
                }                
            }

            ans++;
        }
        
        return -1;
    }
}