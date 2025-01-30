// https://leetcode.com/problems/word-pattern/

class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map = new HashMap<>();
        int i = 0, j = 0;
        for (;i < pattern.length() && j < s.length(); i++, j++){
            StringBuilder builder = new StringBuilder();

            while(s.charAt(j) != ' ' ){
                builder.append(s.charAt(j));
                if (j == s.length()-1)
                    break;
                j++;
            }

            String word = builder.toString();
            if (map.containsKey(pattern.charAt(i))){
                if (!map.get(pattern.charAt(i)).equals(word))
                    return false;
            } else {
                if (map.containsValue(word))
                    return false;
                else
                    map.put(pattern.charAt(i), word);
            }
        }
        if ((i == pattern.length()) && (j == s.length()))
            return true;
        else
            return false;
    }
}
