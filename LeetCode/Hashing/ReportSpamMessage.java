///  https://leetcode.com/problems/report-spam-message/description/

class Solution {
    public boolean reportSpam(String[] message, String[] bannedWords) {
        HashSet<String> banned = new HashSet<>(); 
        for(String word : bannedWords){
            banned.add(word);
        }

        int c = 0, i=0;
        while(c < 2 && i<message.length){
            if(banned.contains(message[i++]))
                c++;
        }

        return c >= 2;
    }
}