///  https://leetcode.com/problems/zero-array-transformation-ii/description/


//Time: O(log(M)⋅(N+M))             Space: O(N)
class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int left = 0, right = queries.length;
        int ans = -1;

        while(left <= right){
            int mid = (left+right)/2;
            if(isZeroArray(nums, queries, mid))
            {    
                right = mid-1;
                ans = mid;
            }
            else
                left = mid+1;
        }
        return ans;
    }

    private boolean isZeroArray(int[] arr, int[][] queries, int n){
        int[] cumSum = new int[arr.length];

        for(int i=0; i<n;i++){
            int[] query = queries[i];
            
            cumSum[query[0]] += query[2];
            if(query[1]+1 < cumSum.length)  
                cumSum[query[1]+1] -= query[2];
        }

        if(cumSum[0] < arr[0]) 
            return false;

        for(int i=1; i<cumSum.length; i++){
            cumSum[i] += cumSum[i-1];
            
            if(cumSum[i] < arr[i]) 
                return false;
        }

        return true;
    }

}