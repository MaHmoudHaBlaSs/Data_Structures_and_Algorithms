///  https://leetcode.com/problems/minimum-distance-between-three-equal-elements-ii/description/

class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        
        int minDistance = Integer.MAX_VALUE;

        for (List<Integer> indices : map.values()) {
            if (indices.size() >= 3) {                
                for (int i = 0; i + 2 < indices.size(); i++) {
                    int a = indices.get(i);
                    int b = indices.get(i + 1);
                    int c = indices.get(i + 2);
                    
                    int distance = Math.abs(a - b) + Math.abs(b - c) + Math.abs(c - a);
                    minDistance = Math.min(minDistance, distance);
                }
            }
        }
        
        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }
}