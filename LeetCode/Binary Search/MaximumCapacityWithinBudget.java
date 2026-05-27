///  https://leetcode.com/problems/maximum-capacity-within-budget/description/

class Solution {
    public int maxCapacity(int[] costs, int[] capacity, int budget) {
        int n = costs.length; 
        int[][] arr = new int[n][3]; 

        for(int i=0; i<n; ++i){
            arr[i] = new int[]{costs[i], capacity[i], -1};
        }

        Arrays.sort(arr, (a,b) -> Integer.compare(a[0], b[0]));
        arr[0][2] = 0;

        for(int i=1; i<n; ++i){
            if(arr[i][1] > arr[arr[i-1][2]][1])
                arr[i][2] = i;
            else arr[i][2] = arr[i-1][2];
        }

        int ans = 0;
        for(int i=n-1; i>=0; --i){
            if(arr[i][0] < budget){
                ans = Integer.max(ans, 
                    arr[i][1] + maxCapacityWithinBudget(arr, budget-arr[i][0]-1, i));
            }
        }

        return ans; 
    }

    private int maxCapacityWithinBudget(int[][] arr, int budget, int exceptIdx){
        int ansIdx = -1; 
        int l=0, r=arr.length-1; 

        while(l<=r){
            int mid = (l+r) >> 1;

            if(arr[mid][0] <= budget){
                ansIdx = mid; 
                l = mid+1;
            }
            else r = mid-1;
        }

        if(ansIdx == -1) return 0;

        if(arr[ansIdx][2] == exceptIdx){
            while(--ansIdx >= 0){
                if(arr[ansIdx][2] != exceptIdx){
                    return arr[arr[ansIdx][2]][1];
                }
            }
        }

        if(ansIdx == -1) return 0;

        return arr[arr[ansIdx][2]][1];
    }
}