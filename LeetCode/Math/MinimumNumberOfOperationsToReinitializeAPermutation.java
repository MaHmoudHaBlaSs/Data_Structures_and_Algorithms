///   https://leetcode.com/problems/minimum-number-of-operations-to-reinitialize-a-permutation/description/

class Solution {
    public int reinitializePermutation(int n) {
        int[] prem = new int[n];
        for(int i=0; i<n; i++) prem[i] = i;

        for(int oper=1; oper<n+1; oper++){
            boolean okay = true;
            int[] arr = new int[n];

            for(int i=0; i<n; i++){
                if((i&1) == 0) {
                    arr[i] = prem[i/2];
                }
                else arr[i] = prem[(n/2) + (i-1)/2];

                if(arr[i] != i) okay = false;
            }

            prem = arr;
            if(okay) return oper;
        }

        return 1;
    }
}