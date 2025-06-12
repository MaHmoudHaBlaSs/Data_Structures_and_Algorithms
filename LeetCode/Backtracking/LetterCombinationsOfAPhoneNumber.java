// https://leetcode.com/problems/letter-combinations-of-a-phone-number

class Solution {
    List<String> combs = new LinkedList<>();
    Map<Character, String> map = new HashMap<>();
    StringBuilder str = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return combs;

        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        recurse(0, digits);

        return combs;
    }

    public void recurse(int step, String digits){
        if (step == digits.length()){ // Base Case
            combs.add(str.toString());
            return;
        }
        
        for (char ch: map.get(digits.charAt(step)).toCharArray()){
            str.append(ch); // Do
            recurse(step+1, digits); // Recurse
            str.deleteCharAt(str.length()-1); // Undo
        }
    }
}