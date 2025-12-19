/// https://leetcode.com/problems/jump-game-vi/description/

class Solution {
public:
    int maxResult(vector<int>& nums, int k) {
        int n = nums.size();
        vector<int> dp(n);

        // max-heap: (dp value, index)
        priority_queue<pair<int, int>> pq;

        for (int i = n - 1; i >= 0; --i) {
            while (!pq.empty() && pq.top().second - i > k)
                pq.pop();

            dp[i] = nums[i] + (pq.empty() ? 0 : pq.top().first);
            pq.push({dp[i], i});
        }

        return dp[0];
    }
};