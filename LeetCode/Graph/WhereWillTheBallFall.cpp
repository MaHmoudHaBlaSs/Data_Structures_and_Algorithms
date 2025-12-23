/// https://leetcode.com/problems/where-will-the-ball-fall/description/

class Solution {
    int dfs(int r, int c, vector<vector<int>>& grid){
        if(c == grid[0].size()) return -1;
        if(r == grid.size()) return c;

        int redirect = grid[r][c];
        if(c+redirect < 0 || c+redirect == grid[0].size() || grid[r][c+redirect] != redirect)
            return -1; 

        return dfs(r+1, c+redirect, grid); 
    }
public:
    vector<int> findBall(vector<vector<int>>& grid) {
        vector<int> ans; 
        for(int i=0; i<grid[0].size(); ++i){
            ans.push_back(dfs(0,i,grid));
        }    

        return ans;
    }
};