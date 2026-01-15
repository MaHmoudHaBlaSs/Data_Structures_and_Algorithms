///   https://leetcode.com/problems/rank-teams-by-votes/description/

class Solution {
    public String rankTeams(String[] votes) {
        int[][] freq = new int[26][26];
        HashSet<Character> set = new HashSet<>();
        
        for(String vote : votes){
            for(int i=0; i<vote.length(); ++i){
                freq[vote.charAt(i) - 'A'][i]++;                
            }
        }

        for(int i=0; i<votes[0].length(); ++i){
            set.add(votes[0].charAt(i));
        }
        
        PriorityQueue<Statistic> pq = new PriorityQueue<>((stat1, stat2)->{
            for (int i=0; i<26; ++i){
                if(stat1.freq[i] > stat2.freq[i]) return -1;
                if(stat1.freq[i] < stat2.freq[i]) return 1;
            }
            
            return stat1.ch - stat2.ch;
        });
        
        for(int i=0; i<26; ++i){
            char ch = (char) ('A'+i);
            if(set.contains(ch))
                pq.offer(new Statistic(ch, freq[i]));
        }
        
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()){
            sb.append(pq.poll().ch);
        }
        
        return sb.toString();
    }
    
    static class Statistic{
        char ch ;
        int[] freq;

        public Statistic(char ch, int[] freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }
}