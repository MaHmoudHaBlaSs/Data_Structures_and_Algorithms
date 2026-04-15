///  https://leetcode.com/problems/maximum-value-of-concatenated-binary-segments/description/

class Solution {
    private static final long MOD = 1_000_000_007L;
    public int maxValue(int[] nums1, int[] nums0) {
        int n = nums1.length;
        int[][] arr = new int[n][2];

        for(int i=0; i<n; ++i){
            arr[i] = new int[]{ nums0[i], nums1[i]};
        }

        Arrays.sort(arr, (a,b) -> {
            if(a[0] == 0 && b[0] == 0) return a[1]-b[1];
            if(b[0] == 0) return -1;
            if(a[0] == 0) return 1;

            if(a[1] != b[1]) return a[1] - b[1];
            return b[0]-a[0]; 
        });

        long w = 1, ans = 0; 
        for(int[] a : arr){
            int zeros = a[0], ones = a[1]; 
            
            while(zeros-- > 0){
                w = (w*2) % MOD;
            }
            
            while (ones-- > 0){
                ans = (ans+w) % MOD;
                w = (w*2) % MOD;
            }
        }
        
        return (int)ans;
    }
}