///   https://leetcode.com/problems/reorder-data-in-log-files/description/

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        int last = logs.length;

        for(int i=logs.length-1; i >= 0; i--){
            String log = logs[i];
            if(Character.isDigit(log.charAt(log.length()-1))) {
                logs[i] = logs[--last];
                logs[last] = log;
            }
        }

        Arrays.sort(logs, 0, last, (s1,s2) ->{
            int i1 = s1.indexOf(' '), i2=  s2.indexOf(' '); 
            
            String content1 = s1.substring(i1+1),  content2 = s2.substring(i2+1);
            int comp = content1.compareTo(content2);
            if(comp > 0)
                return 1;
            else if(comp < 0)
                return -1;

            return s1.substring(0,i1).compareTo(s2.substring(0,i2));
        });

        return logs;
    }
}