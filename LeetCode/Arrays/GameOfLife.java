// https://leetcode.com/problems/game-of-life/description/

class Solution {
    // T: O(n2)
    public void gameOfLife(int[][] board) {
        int rows = board.length, cols = board[0].length;
        int[][] lives = new int[rows][cols];
        
        // T: O(n2)
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                lives[i][j] = getLives(board, i, j);
            }
        }
        // T: O(n2)
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if (board[i][j] == 1)
                    board[i][j] = (lives[i][j] < 2 || lives[i][j] > 3)?0:1;
                else
                    board[i][j] = (lives[i][j] == 3)?1:0;
            }
        }
    }
    // O(8) >> O(1)
    public int getLives(int[][] board, int x, int y){
        int lives = (board[x][y] == 0)?0:-1;
        
        for (int i = x-1; i < x+2; i++){
            if (i >= board.length || i == -1) continue;
            for (int j = y-1; j < y+2; j++){
                if (j == board[0].length || j == -1) continue;
                lives += board[i][j];
            }
        }
        return lives;
    }
}
