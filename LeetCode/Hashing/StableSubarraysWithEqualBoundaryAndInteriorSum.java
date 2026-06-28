///  https://leetcode.com/problems/stable-subarrays-with-equal-boundary-and-interior-sum/description/

class Solution {
    public long countStableSubarrays(int[] capacity) {
        HashMap<Integer, HashMap<Long, Integer>> map = new HashMap<>();
        long ans = 0, prefix = capacity[0];

        for(int i=1; i<capacity.length; ++i){
            var leftMap = map.get(capacity[i]);  

            if(leftMap != null){
                ans += leftMap.getOrDefault(prefix - capacity[i], 0);
            }


            var mp = map.computeIfAbsent(capacity[i-1], k -> new HashMap<>());
            mp.put(prefix, mp.getOrDefault(prefix,0)+1);
            
            prefix += capacity[i];
        }

        return ans;
    }
}