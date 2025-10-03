///  https://leetcode.com/problems/jump-game-vii/

class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        if(s.charAt(n-1) == '1') return false;
        boolean[] reachable = new boolean[n]; 
        reachable[0] = true; 

        int right = minJump; 
        for(int left=0; left<n; ++left){
            if(!reachable[left]) continue; 
            
            right = Math.max(right, left+minJump);

            while(right < Math.min(n, left+maxJump+1)) {
                if(s.charAt(right) == '0') 
                    reachable[right] = true; 
                ++right;
            }
        } 

        return reachable[n-1];
    }
}