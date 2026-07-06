// https://leetcode.com/problems/sum-of-distances/description/

class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long arr[] = new long[n];
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> indices = entry.getValue();
            int m = indices.size();
            
            /*
             * DERIVATION OF THE EQUATIONS:
             * 
             * For a group of indices: [i₀, i₁, i₂, ..., iₘ₋₁]
             * (where indices are sorted because we traversed array left to right)
             * 
             * For any index iₖ at position 'k' in this group:
             * 
             * LEFT DISTANCE (sum of distances to all previous indices):
             *   = (iₖ - i₀) + (iₖ - i₁) + ... + (iₖ - iₖ₋₁)
             *   = (iₖ + iₖ + ... + iₖ) - (i₀ + i₁ + ... + iₖ₋₁)
             *            k times
             *   = iₖ * k - (sum of previous indices)
             *   = idx * i - prefixSum[i]
             * 
             * RIGHT DISTANCE (sum of distances to all future indices):
             *   = (iₖ₊₁ - iₖ) + (iₖ₊₂ - iₖ) + ... + (iₘ₋₁ - iₖ)
             *   = (iₖ₊₁ + iₖ₊₂ + ... + iₘ₋₁) - (iₖ + iₖ + ... + iₖ)
             *                                     (m - 1 - k) times
             *   = (sum of future indices) - iₖ * (m - 1 - k)
             *   = (prefixSum[m] - prefixSum[i + 1]) - idx * (m - 1 - i)
             * 
             * TOTAL DISTANCE at index idx = leftDist + rightDist
             */
            
            long[] prefixSum = new long[m + 1];
            for (int i = 0; i < m; i++) {
                prefixSum[i + 1] = prefixSum[i] + indices.get(i);
            }
            
            // Calculate distances using prefix sums
            for (int i = 0; i < m; i++) {
                int idx = indices.get(i);
                
                // Distance to all left occurrences
                long leftDist = (long) idx * i - prefixSum[i];
                
                // Distance to all right occurrences
                long rightDist = (prefixSum[m] - prefixSum[i + 1]) - (long) idx * (m - 1 - i);
                
                arr[idx] = leftDist + rightDist;
            }
        }
        return arr;
    }
}