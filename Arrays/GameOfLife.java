// https://leetcode.com/problems/game-of-life/description/

class Solution {
    // T: O(n2)
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        int[][] lives = new int[m][n];

        // T: O(n2)
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                lives[i][j] = getLives(board, m, n, i, j);
            }
        }

        // T: O(n2)
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (board[i][j] == 1){
                    if (lives[i][j] < 2 || lives[i][j] > 3)
                        board[i][j] = 0;
                }else{
                    if (lives[i][j] == 3)
                        board[i][j] = 1;
                }
                    
            }
        }
    }
    // O(8) >> O(1)
    public int getLives(int[][] board, int m, int n, int x, int y){
        int lives = (board[x][y] == 0)?0:-1;
        for (int i = x-1; i < x+2; i++){
            if (i == -1 || i == m)
                continue;
            for (int j = y-1; j < y+2; j++){
                if (j == -1 || j == n)
                    continue;
                lives += board[i][j];
            }
        }
        return lives;
    }
}
