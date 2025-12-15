/// https://leetcode.com/problems/lexicographical-numbers/description/


class Solution {
private:
    void dfs(int num, int n, vector<int>& ans){
        for (int i = (num == 0 ? 1 : 0); i < 10; ++i) {
            int newNum = num * 10 + i;

            if (newNum > n) return;

            ans.push_back(newNum);
            dfs(newNum, n, ans);
        }        
    }
public:
    vector<int> lexicalOrder(int n) {
        vector<int> ans;
        ans.reserve(n); 
        dfs(0, n, ans); 
        return ans;
    }    
};