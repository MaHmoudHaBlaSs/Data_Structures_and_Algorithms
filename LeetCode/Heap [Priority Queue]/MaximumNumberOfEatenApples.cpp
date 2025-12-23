///  https://leetcode.com/problems/maximum-number-of-eaten-apples/description/

class Solution {
public:
    int eatenApples(vector<int>& apples, vector<int>& days) {
        priority_queue<pair<int,int>> pq; 
        
        int eaten = 0, n = days.size();
        for(int day = 0; day < n || !pq.empty(); ++day){
            if(day < n && apples[day] != 0){ 
                pq.push({-(day+days[day]), apples[day]});
            }
            
            while (!pq.empty() && (-pq.top().first <= day || pq.top().second <= 0)){
                pq.pop();
            }
            
            if(!pq.empty()){
                auto top = pq.top();
                pq.pop();

                if(--top.second > 0) {
                    pq.push(top);
                }
                eaten++;
            }
        }

        return eaten;
    }
};  