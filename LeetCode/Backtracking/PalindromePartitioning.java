// https://leetcode.com/problems/palindrome-partitioning/description/

class Solution {
    List<List<String>> groups = new LinkedList<>();
    List<String> list = new LinkedList<>();

    // Check for palindrome before branching
    // use i, j pointers instead of using new string at each level

    public List<List<String>> partition(String s) {
        dfs(s, 0);
        return groups;
    }
    public void dfs(String s, int i){
        if (i == s.length()){
            groups.add(new ArrayList<>(list));
            return;
        }

        for (int j = i; j < s.length(); j++){
            if (isPalindrome(s, i, j)){
                list.add(s.substring(i, j+1)); // Do
                dfs(s, j+1); // Recurse
                list.removeLast(); // Undo
            }
        }
    }

    public boolean isPalindrome(String subs, int left ,int right){
        while (left <= right){
            if (subs.charAt(left) != subs.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}