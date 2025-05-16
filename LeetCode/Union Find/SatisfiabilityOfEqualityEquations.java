///  https://leetcode.com/problems/satisfiability-of-equality-equations/description/


class Solution {
    private int[] parent = new int[26];

    private int find(int x){
        if(parent[x] != x)
            parent[x] = find(parent[x]);

        return parent[x];
    }
    private boolean union(int x, int y){
        int pX = find(x), pY = find(y);

        if(pX == pY) return false;

        parent[pY] = pX;
        return true;
    }
    
    public boolean equationsPossible(String[] equations) {
        for(int i=0; i<26; i++) parent[i] =i;

        for(String equation : equations){
            if(equation.charAt(1) == '!') continue;
            int c1 = equation.charAt(0)-'a', c2 = equation.charAt(3)-'a';
            
            union(c1, c2);
        }        
        
        for(String equation : equations){
            if(equation.charAt(1) == '=') continue;
            int c1 = equation.charAt(0)-'a', c2 = equation.charAt(3)-'a';
            
            if(find(c1) == find(c2)) return false;
        }

        return true;
    }
}