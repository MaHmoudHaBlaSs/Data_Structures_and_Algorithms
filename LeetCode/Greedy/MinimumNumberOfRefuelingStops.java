///   https://leetcode.com/problems/minimum-number-of-refueling-stops/description/

/*
you want to delay refueling as long as possible, but when you need to refuel, 
you should choose the station with the maximum amount of fuel from all stations you've passed
*/


//Time: O(N.log(N))           Space: O(N)       N = stations.length
class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if(target <= startFuel) return 0;

        if(stations.length==0) return -1;


        //define comparator to sort feules descendingly 
        PriorityQueue<Integer> pq =  new PriorityQueue<>((fuel1,fuel2) -> fuel2 - fuel1); 
        
        int count=0, position = 0, tank=startFuel, i=0, n=stations.length;
        while(position < target && tank > 0){
            position += tank; 
            tank = 0;

            if(position >= target) return count; 

            while(i<n && stations[i][0] <= position)
                pq.add( stations[i++][1] );

            if(pq.isEmpty()) return -1; 

            tank += pq.poll();
            count++; 
        } 

        return position >= target ? count : -1;  
    }
}