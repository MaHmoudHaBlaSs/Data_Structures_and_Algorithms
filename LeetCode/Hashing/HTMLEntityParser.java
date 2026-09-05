/// https://leetcode.com/problems/html-entity-parser/description/

class Solution {
    public String entityParser(String text) {
        HashMap<String, String> mp = new HashMap<>();
        mp.put("&quot;", "\"");
        mp.put("&apos;", "'");
        mp.put("&amp;", "&");
        mp.put("&gt;", ">");
        mp.put("&lt;", "<");
        mp.put("&frasl;", "/");

        int n = text.length();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; ++i){
            if(text.charAt(i) == '&'){
                String word = "&";

                for(int j=1; j<7 && i+j<n; ++j){
                    if(text.charAt(i+j) == '&') break; 

                    word += text.charAt(i+j);

                    if(mp.containsKey(word)){ 
                        break;
                    }
                }

                sb.append(mp.getOrDefault(word, word));
                i += word.length()-1;
            }else{
                sb.append(text.charAt(i));
            }
        }

        return sb.toString();
    }
}
