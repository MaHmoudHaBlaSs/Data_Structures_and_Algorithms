///   https://leetcode.com/problems/count-substrings-that-differ-by-one-character/description/

class Solution {
    public int countSubstrings(String s, String t) {
        ArrayList<String>[] arr = new ArrayList[t.length()+1];
        
        for (int i = 0; i < t.length(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < t.length(); j++) {
                sb.append(t.charAt(j));
                int len = j-i+1;
                if(arr[len] == null) arr[len] = new ArrayList<>();
                arr[len].add(sb.toString());
            }
        }
        
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            
            for (int j = i; j < s.length(); j++) {
                sb.append(s.charAt(j));
                int len = j-i+1;
                String str = sb.toString();
                
                if(len < arr.length && arr[len] != null){
                    for (String sub : arr[len]) {
                        if(differByOneCharacter(str, sub)) answer++;
                    }
                }
            }
        }
        
        return answer;
    }
    
    private boolean differByOneCharacter(String s, String t){
        short c = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == t.charAt(i)) continue;
            
            c++;
            if(c == 2) return false;
        }
        
        return c == 1;
    }
}