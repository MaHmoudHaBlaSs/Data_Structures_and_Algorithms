//https://leetcode.com/problems/intersection-of-two-arrays-ii/description/

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        
        for (int num : nums2) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        
        List<Integer> result = new ArrayList<>();
        for (int num : nums1) {
            if (freqMap.containsKey(num) && freqMap.get(num) > 0) {
                result.add(num);
                freqMap.put(num, freqMap.get(num) - 1);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}