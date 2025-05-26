// https://leetcode.com/problems/letter-case-permutation/

class Solution {
    List<String> perms = new ArrayList<>();
    StringBuilder temp = new StringBuilder();

    public List<String> letterCasePermutation(String s) {
        dfs(0, s.toLowerCase());
        return perms;     
    }
    // subtracte 32 to convert small to capital and add 35 vise
    public void dfs(int i, String s){
        if (i == s.length()){
            perms.add(temp.toString());
            return;
        }

        char ch = s.charAt(i);
        
        if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')){ // If Character
            temp.append((char) (ch-32)); // Do
            dfs(i+1, s); // Try with Upper Case - Recurse
            temp.deleteCharAt(temp.length()-1); // Undo
        }

        temp.append(ch); // Do
        dfs(i+1, s); // Try with Lower Case or add the Digit and move on. - Recurse
        temp.deleteCharAt(temp.length()-1); // Undo
    }
}
