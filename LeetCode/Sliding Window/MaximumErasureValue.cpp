/// https://leetcode.com/problems/maximum-erasure-value/description/

class Solution {
public:
    int maximumUniqueSubarray(vector<int>& nums) {
        int left = 0, n = nums.size(), sum=0; 
        unordered_set<int> set(); 
        int ans = 0; 

        for(int right=0; right<n; ++right){
            while(left < right && set.contains(nums[right])){
                set.erase(nums[left]);
                sum -= nums[left++];
            }
            sum += nums[right]; 
            set.insert(nums[right]);
            ans = max(ans, sum); 
        }

        return ans; 
    }
};