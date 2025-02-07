// https://leetcode.com/problems/game-of-life/description/

class Solution {
    // T: O(n2)
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        int[][] next = new int[m][n];
        
        // T: O(n2)
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                int lives = getLives(board, m, n, i, j);

                if (board[i][j] == 1){
                    if (lives < 2 || lives > 3)
                        next[i][j] = 0;
                    else 
                        next[i][j] = 1;
                } else {
                    if (lives == 3)
                        next[i][j] = 1;
                }
            }
        }
        // T: O(n2)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = next[i][j]; 
            }
        }
    }
    
    // O(8) >> O(1)
    public int getLives(int[][] board, int m, int n, int x, int y){
        int lives = (board[x][y] == 1)?-1:0;
        int rows = x+2, cols = y+2;

        for (int i = x-1;i < rows && i < m; i++){
            if (i < 0)
                continue;
            for (int j = y-1; j < cols && j < n; j++){
                if (j < 0)
                    continue;
                lives += board[i][j];
            }
        }
        return lives;
    }
}
