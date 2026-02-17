///  https://leetcode.com/problems/the-k-strongest-values-in-an-array/description/

class Solution {
    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);

        int i=0, l=0, r=arr.length-1, m = arr[r/2]; 
        int[] ans = new int[k]; 

        while(i<k){
            if(arr[r] - m >= m - arr[l]) ans[i++] = arr[r--];
            else ans[i++] = arr[l++];
        }

        return ans;
    }
}
