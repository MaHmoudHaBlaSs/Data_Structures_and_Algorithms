// https://leetcode.com/problems/unique-binary-search-trees

class Solution {
    int[] memo = new int[20];
    public int numTrees(int n) {
        if (n == 0 || n == 1) return memo[n] = 1; // Base Case

        if (memo[n] != 0) return memo[n];
        
        // To know how many trees can formed out of 4 nodes [1, 2, 3, 4]
        // you need to assume each node as a root node and get all probabilities
        // Ex: tree(3) = tree(0)*tree(2) 1 as Root [0 left - 2 Right] 
        //               + tree(1)*tree(1) 2 as Root [1 Left - 1 Right]
        //               + tree(2)*tree(0) 3 as Root [2 Left - 0 Right]
        
        for (int i = 0; i < n; i++){
            memo[n] += numTrees(i) * numTrees(n-i-1);
        }
        return memo[n];
    }
}