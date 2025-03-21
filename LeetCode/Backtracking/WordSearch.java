// https://leetcode.com/problems/word-search/description/

// Optimal Brute Force.
class Solution {
    Set<Integer> visited = new HashSet<>();

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (checkSequence(board, i, j, word))
                    return true;
            }
        }
        return false;
    }
    public boolean checkSequence(char[][] board, int i, int j, String sequence){
        if (sequence == "" || sequence == null) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return false;
        if (visited.contains(i*board[0].length+j)) return false;
        if (board[i][j] != sequence.charAt(0)) return false;

        visited.add(i*board[0].length+j);
        boolean res = checkSequence(board, i-1, j, sequence.substring(1))
            || checkSequence(board, i+1, j, sequence.substring(1))
            || checkSequence(board, i, j-1, sequence.substring(1))
            || checkSequence(board, i, j+1, sequence.substring(1));
        visited.remove(i*board[0].length+j);
        return res;
    }
}
