class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map = new HashMap<>();

        int i,j;
        for (i = 0, j = 0; i < pattern.length(); i++, j++){
            StringBuilder str = new StringBuilder();
            while (j < s.length() && s.charAt(j) != ' '){
                str.append(s.charAt(j));
                j++;
            }
            String word = str.toString();

            if (map.containsKey(pattern.charAt(i))){
                if (!map.get(pattern.charAt(i)).equals(word)) return false;
            }else{
                if (map.containsValue(word)) return false;
                else map.put(pattern.charAt(i), word);
            }
        }
        return i == pattern.length() && j == s.length()+1;
    }
}
