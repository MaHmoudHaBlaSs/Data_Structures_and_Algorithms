///  https://leetcode.com/problems/longest-turbulent-subarray/

class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int ans = 1, n = arr.length; 

        boolean flag = true;
        for(int i=0; i<n-1; i++){
            if(arr[i] > arr[i+1]) flag = true; 
            else if(arr[i] < arr[i+1]) flag = false;
            else continue;

            int j = i;
            while(j+1 < n && arr[j] != arr[j+1] && (arr[j] > arr[j+1]) == flag) {
                j++;
                flag = !flag;
            }

            ans = Math.max(ans, j-i+1);
            if(j-1 > i) i = j-1;
        } 

        return ans; 
    }
}