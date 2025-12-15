///  https://leetcode.com/problems/number-of-smooth-descent-periods-of-a-stock/description/

class Solution {
public:
    long long getDescentPeriods(vector<int>& prices) {
        long long ans = 1; 
        int start = 0; 
        
        for(int i=1;i<prices.size(); ++i){
            if(prices[i] + 1 == prices[i-1]){ 
                ans += i-start+1; 
            }else{
                start = i; 
                ans++;
            }
        }

        return ans; 
    }
};