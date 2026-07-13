///  https://leetcode.com/problems/distinct-points-reachable-after-substring-removal/description/


class Solution {
    public int distinctPoints(String s, int k) {
        int n = s.length();
        int[] ud = new int[n+1], rl = new int[n+1];
        
        if(k == n) return 1;

        for(int i=0; i<n; ++i){
            char c = s.charAt(i);

            rl[i+1] = rl[i];
            ud[i+1] = ud[i];

            if(c == 'U'){ 
                ud[i+1]++;
            }else if(c == 'D'){ 
                ud[i+1]--;
            }else if(c == 'R'){ 
                rl[i+1]++;
            }else { 
                rl[i+1]--;
            }
        }

        HashSet<Map.Entry<Integer, Integer>> set = new HashSet<>();

        for(int i=0; i<=n-k; ++i){

            int x = rl[i], y = ud[i];

            x += rl[n] - rl[i+k]; 
            y += ud[n] - ud[i+k]; 

            set.add(Map.entry(x,y));
        }

        return set.size();
    }
}