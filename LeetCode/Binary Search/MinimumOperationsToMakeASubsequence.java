/// https://leetcode.com/problems/minimum-operations-to-make-a-subsequence/description/

class Solution {
    public int minOperations(int[] target, int[] arr) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i=0; i<target.length; ++i) mp.put(target[i], i);

        int[] tails = new int[target.length];
        int longestIncreasingSubsequence = 0;
        for(int num : arr){
            int idx = mp.getOrDefault(num, -1);
            if(idx == -1) continue;

            int l = 0, r = longestIncreasingSubsequence;
            while(l < r){
                int m = (l+r) >>> 1;
                if(tails[m] < idx) l = m+1;
                else r = m;
            }

            tails[l] = idx;
            if(l == longestIncreasingSubsequence) ++longestIncreasingSubsequence;
        }
        
        return target.length - longestIncreasingSubsequence;
    }
}