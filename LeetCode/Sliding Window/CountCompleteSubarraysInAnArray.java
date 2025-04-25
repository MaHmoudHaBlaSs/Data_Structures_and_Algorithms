///     https://leetcode.com/problems/count-complete-subarrays-in-an-array/description/

class Solution {
    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) set.add(num); 
        
        int distinct = set.size();
        HashMap<Integer, Integer> mp = new HashMap<>();
        int right = 0, n = nums.length, ans = 0; 
        
        for(int left=0; left <n; left++){
            while(right < n && mp.size() < distinct)
                mp.put(nums[right], mp.getOrDefault(nums[right++],0) + 1);
            
            if(mp.size() == distinct) ans += n-right+1;
            
            int leftFreq = mp.get(nums[left]) ;
            if(leftFreq > 1) mp.put(nums[left],leftFreq-1);
            else mp.remove(nums[left]); 
        }
        
        return ans; 
    }
}