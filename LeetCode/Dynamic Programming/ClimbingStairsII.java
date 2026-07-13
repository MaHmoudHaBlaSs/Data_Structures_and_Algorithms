///  https://leetcode.com/problems/climbing-stairs-ii/description/

class Solution {
    public int climbStairs(int n, int[] costs) {
        int[] arr = new int[]{0,0,0};

        for(int i=0; i<n; ++i){
            int cost = Integer.min(costs[i] + arr[2] + 1, costs[i] + arr[1] + 4); 
            cost = Integer.min(cost, costs[i] + arr[0] + 9); 

            arr[0] = arr[1];
            arr[1] = arr[2];
            arr[2] = cost; 
        }

        return arr[2];
    }
}