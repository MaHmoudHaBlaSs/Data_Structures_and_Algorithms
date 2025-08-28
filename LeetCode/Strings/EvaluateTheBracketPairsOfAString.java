///  https://leetcode.com/problems/evaluate-the-bracket-pairs-of-a-string/description/

class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        StringBuilder ans = new StringBuilder();

        HashMap<String,String> map  = knowledge.stream().collect(
                HashMap::new,
                (mp, pair) -> mp.put(pair.get(0), pair.get(1)),
                HashMap::putAll
        );       

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(' ){
                StringBuilder key = new StringBuilder();
                while(s.charAt(++i) != ')')
                    key.append(s.charAt(i));

                ans.append(map.getOrDefault(key.toString(), "?"));
            }
            else ans.append(c);
        }

        return ans.toString();
    }
}