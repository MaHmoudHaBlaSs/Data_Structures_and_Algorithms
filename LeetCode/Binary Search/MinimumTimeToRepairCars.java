///    https://leetcode.com/problems/minimum-time-to-repair-cars/description/


//Time: O(N.log(N))         Space: O(1)
class Solution {
    public long repairCars(int[] ranks, int cars) {
        long minRank = 200;
        for(int rank : ranks)
            if(rank < minRank) 
                minRank = rank;
        

        long left = 1, right = minRank * cars * cars, ans = right;

        while(left <= right){
            long mid = (left+right)/2L;

            if(can(ranks,cars,mid)){
                ans = mid; 
                right = mid-1;
            }
            else {
                left = mid +1;
            }
        }

        return ans; 
    }

    //check if the all cars can be repaired in a given time
    private boolean can(int[] ranks,long cars, long time){
        //ith mechanical takes time = ranks[i] * n_i * n_i , where n_i is the number of cars he can repair 
        long sum= 0;      // sum of n_i (from i=0 to i=ranks.length)
        for(int rank : ranks){
            sum += (int)Math.sqrt(time/rank); 
        }
        return cars <= sum; 
    }
}