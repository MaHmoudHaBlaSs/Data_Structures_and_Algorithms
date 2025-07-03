// https://leetcode.com/problems/generate-binary-strings-without-adjacent-zeros

class Solution {
    List<String> groups = new LinkedList<>();
    StringBuilder temp = new StringBuilder();

    public List<String> validStrings(int n) {
        recurse(n);
        return groups;
    }

    public void recurse(int n){
        if (n == 0){
            groups.add(temp.toString());
            return;
        }

        if (temp.length() == 0 || temp.charAt(temp.length()-1) != '0'){
            temp.append('0');
            recurse(n-1);
            temp.deleteCharAt(temp.length()-1);
        }

        temp.append('1');
        recurse(n-1);
        temp.deleteCharAt(temp.length()-1);
    }
}