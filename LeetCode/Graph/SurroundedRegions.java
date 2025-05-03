// https://leetcode.com/problems/surrounded-regions/description/


// T: O(n) >> cells get accessed only 1 time         S: O(n) >> Recursion
class Solution {
    int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public void solve(char[][] board) {
        int rows = board.length, cols = board[0].length; 

        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                // DFS starting from any O cell at boundary
                if (i == 0 || i == rows-1 || j == 0 || j == cols-1 && board[i][j] == 'O')
                    dfs(board, i, j, rows, cols);
            }
        }

        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == '@') board[i][j] = 'O';
            }
        }
    }

    // Only invoked by Cells equal to 'O'
    public void dfs(char[][] board, int x, int y, int rows, int cols){
        if (x < 0 || x >= rows || y < 0 || y >= cols || board[x][y] == 'X') 
            return;
        if (board[x][y] == '@')
            return; // Already visited

        board[x][y] = '@'; // Marked as visited and not surrounded
        for (int[] dir: directions)
            dfs(board, x+dir[0], y+dir[1], rows, cols);
    }
}