///  https://leetcode.com/problems/binary-trees-with-factors/

class Solution {
    //Time: O(n^2)                     Space: O(n)
    public int numFactoredBinaryTrees(int[] arr) {
        final int MOD = 1_000_000_007;
        Arrays.sort(arr);
        Map<Integer, Long> dp = new HashMap<>();
        

        for (int i = 0; i < arr.length; i++) {
            //each number can be a tree with one node
            dp.put(arr[i], 1L);
            
            for (int j = 0; j < i; j++) {
                
                if (arr[i] % arr[j] != 0) continue;
                  
                //arr[j] is a potential child
                int right = arr[i] / arr[j];
                
                if (dp.containsKey(right)) {
                    long ways = (dp.get(arr[j]) * dp.get(right)) % MOD;
                    dp.put(arr[i], (dp.get(arr[i]) + ways) % MOD);
                }
                
            }
        }
        

        long result = 0;
        for (long val : dp.values()) {
            result = (result + val) % MOD;
        }
        
        return (int) result;
    }
}