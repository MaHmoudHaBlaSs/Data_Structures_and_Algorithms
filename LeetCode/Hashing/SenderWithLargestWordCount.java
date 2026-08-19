///  https://leetcode.com/problems/sender-with-largest-word-count/description/

class Solution {
    public String largestWordCount(String[] messages, String[] senders) {
        HashMap<String, Integer> mp = new HashMap<>();
        int n = senders.length, max = 0;
        String ans = ""; 

        for(int i=0; i<n; ++i){
            String[] arr = messages[i].split(" ");
            String sender = senders[i];

            int next = mp.getOrDefault(sender, 0) + arr.length; 
            mp.put(sender, next);

            if(next > max){
                ans = sender;
                max = next;
            }else if(next == max){
                if(sender.compareTo(ans) > 0) 
                    ans = sender;
            }
        }

        return ans;
    }
}