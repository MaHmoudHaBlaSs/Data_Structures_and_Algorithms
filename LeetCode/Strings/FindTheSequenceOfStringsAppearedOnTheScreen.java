////  https://leetcode.com/problems/find-the-sequence-of-strings-appeared-on-the-screen/description/

class Solution {
    public List<String> stringSequence(String target) {
       String screen = ""; 
        List<String> list = new ArrayList<>(); 

        for(int i=0; i<target.length(); ++i){
            char c = target.charAt(i);

            for(char j = 'a'; j<=c; ++j){
                list.add(screen + j);
            }

            screen += c;
        }

        return list;
    }
}