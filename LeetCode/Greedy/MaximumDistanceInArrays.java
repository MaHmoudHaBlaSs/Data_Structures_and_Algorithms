// https://leetcode.com/problems/maximum-distance-in-arrays/description/

class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int max = arrays.get(0).get(arrays.get(0).size() - 1);
        int min = arrays.get(0).get(0);
        int maxDistance = 0;
        
        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> currentArray = arrays.get(i);
            int currentMin = currentArray.get(0);
            int currentMax = currentArray.get(currentArray.size() - 1);
            
            int dist1 = Math.max(maxDistance, Math.abs(currentMax - min));
            int dist2 = Math.max(maxDistance, Math.abs(max - currentMin));
            int currMaxDistance = Math.max(dist1, dist2);
            
            maxDistance = Math.max(maxDistance, currMaxDistance);
            max = Math.max(max, currentMax);
            min = Math.min(min, currentMin);
        }
        return maxDistance;

    }
}