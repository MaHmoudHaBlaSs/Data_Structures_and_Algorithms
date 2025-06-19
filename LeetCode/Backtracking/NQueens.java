// https://leetcode.com/problems/n-queens

class Solution {
    List<List<String>> sols = new LinkedList<>();
    List<Integer> positions = new LinkedList<>();

    public List<List<String>> solveNQueens(int n) {
        recurse(-1, n);
        return sols;
    }

    public void recurse(int row, int n){ 
        if (!isSafe(positions))
            return;
    
        if (positions.size() == n){
            // valid solution  
            System.out.println(positions);
            sols.add(generateSolution(positions));
            return;
        }

        for (int col = 0; col < n; col++){
            // Do
            positions.add(col);
            // Recurse
            recurse(row+1, n);
            // Undo
            positions.removeLast();
        }
    }

    public boolean isSafe(List<Integer> positions){
        if (positions.size() < 1 ) return true;
    
        int i = positions.size()-1; 
        int j = positions.get(i); 

        for (int row = 0; row < positions.size()-1; row++){
            if (Math.abs(i - row) == Math.abs(j - positions.get(row)) || j == positions.get(row)){
                return false;
            }
        }
        return true;
    }

    public List<String> generateSolution(List<Integer> positions){
        List<String> queens = new LinkedList<>();
        
        for (int i = 0; i < positions.size(); i++){
            StringBuilder sb = new StringBuilder(".".repeat(positions.size()));
            sb.setCharAt(positions.get(i), 'Q');
            queens.add(sb.toString());
        }
        return queens;
    }
}