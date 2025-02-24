class Solution {
    // T: O(n*m) where m is the length og n'th word.          S: O(n)
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map = new HashMap<>();
        int i = 0;

        for (Character c: pattern.toCharArray()){
            StringBuilder tempWord = new StringBuilder();
            while (i < s.length() && s.charAt(i) != ' '){
                tempWord.append(s.charAt(i));
                i++;
                // Last Break will be when i == Length, 
                // And the outter loop will increament it by 1 to be = length+1
            }
            String word = tempWord.toString();
            if (map.containsKey(c)){
                if (!map.get(c).equals(word)) return false;
            }else{
                if (map.containsValue(word)) return false;
                map.put(c, word);
            }
            i++;
        }
        return i == s.length()+1;
    }
}
