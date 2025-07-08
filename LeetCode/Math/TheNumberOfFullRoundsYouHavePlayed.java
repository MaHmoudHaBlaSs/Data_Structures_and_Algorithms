///  https://leetcode.com/problems/the-number-of-full-rounds-you-have-played/description/ 


class Solution {
    public int numberOfRounds(String loginTime, String logoutTime) {
        int startH = Integer.parseInt(loginTime.substring(0,2)), startM = Integer.parseInt(loginTime.substring(3,5));
        int endH = Integer.parseInt(logoutTime.substring(0,2)), endM = Integer.parseInt(logoutTime.substring(3,5));

        if(startH > endH ||( startH == endH && startM > endM)) endH += 24;
        
        int ans = 0;
        for (int i = 0; i <= (48*60) - 15; i+=15) {
            int roundStartH = i / 60, roundStartM = i % 60;
            int roundEndH = (i + 15)/ 60, roundEndM = (i+15)% 60;
            
            if(roundStartH > startH || (roundStartH == startH && roundStartM >= startM)){
                if(roundEndH < endH || (roundEndH == endH && roundEndM <= endM))  ans++;
            }
        }
        

        return ans;
    }
}