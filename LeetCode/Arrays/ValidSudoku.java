// https://leetcode.com/problems/valid-sudoku/description/

class Solution {
    // You may ask: how it's O(1) and we traverse all rows and columns and also boxes, but the meaning of O(1) is that
    // for any sudoko board you pass the algorithm will take the same time to reach the answer [not proportional to input] 
    // That's because the board size is fixed to 9x9
  
    // T: O(1)           S: O(1)
    public boolean isValidSudoku(char[][] board) {
        // T: O(1)
        if (!checkRows(board) || !checkColumns(board)) return false;

        int  rowStart = 0, rowEnd = 3, colStart = 0, colEnd = 3;
        // T: O(1)
        for (int i = 0; i < 9; i++){
            if (i%3 == 0 && i != 0){
                rowStart += 3; rowEnd += 3;
                colStart = 0; colEnd = 3;
            }
            if(!checkBox(board, rowStart, rowEnd, colStart, colEnd)) return false;
            colStart += 3; colEnd += 3;
        }
        return true;
    }
    public boolean checkBox(char[][] board, int  rowStart, int rowEnd, int colStart, int colEnd){
        Set<Character> set = new HashSet<>();
        for (int i = rowStart; i < rowEnd; i++){
            for (int j = colStart; j < colEnd; j++){
                if (board[i][j] == '.') continue;
                if (set.contains(board[i][j])) return false;
                set.add(board[i][j]);
            }
        }
        return true;
    }
    public boolean checkRows(char[][] board){
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] == '.') continue;
                if (set.contains(board[i][j])) return false;
                set.add(board[i][j]);
            }
            set.clear();
        }
        return true;
    }
    public boolean checkColumns(char[][] board){
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (board[j][i] == '.') continue;
                if (set.contains(board[j][i])) return false;
                set.add(board[j][i]);
            }
            set.clear();
        }
        return true;
    }
}
