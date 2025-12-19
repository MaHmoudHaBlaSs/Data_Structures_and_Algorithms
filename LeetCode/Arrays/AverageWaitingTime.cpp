/// https://leetcode.com/problems/average-waiting-time/description/


class Solution {
public:
    double averageWaitingTime(vector<vector<int>>& customers) {
        double ans = 0; 
        int lastBusy = 0;

        for(int i=0; i<customers.size(); ++i){
            int arrival = customers[i][0], time = customers[i][1]; 
            if(arrival >= lastBusy){
                ans += time;
                lastBusy = arrival + time; 
            }else{
                ans += (time + lastBusy - arrival);
                lastBusy += time; 
            }
        }

        return ans / customers.size(); 
    }
};