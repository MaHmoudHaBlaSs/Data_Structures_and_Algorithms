// https://leetcode.com/problems/game-of-life/description/

class Solution {
    // T: O(n2)          S: O(n)
    public void gameOfLife(int[][] board) {
        boolean[][] nextGen = new boolean[board.length][board[0].length]; // S: O(n)

        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                nextGen[i][j] = predict(board, i, j);
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                board[i][j] = (nextGen[i][j])?1:0;
    }

    // O(8) >> O(1)
    public boolean predict(int[][] board, int x, int y){
        int neighbours = (board[x][y] == 1)?-1:0;
    
        for (int i = x-1; i <= x+1; i++){
            if (i < 0 || i == board.length) continue;
            for (int j = y-1; j <= y+1; j++){
                if (j < 0 || j == board[0].length) continue;
                neighbours += board[i][j];
            }
        }
        return (board[x][y] == 1)?!(neighbours < 2 || neighbours > 3): neighbours == 3;
    }
}
