/// https://leetcode.com/problems/car-fleet/


// Sort cars by position, If current car takes longer to reach target than the car ahead then
// it cannot catch up and forms a new fleet, Otherwise, it will catch up and join the fleet
// Start from last car as it has the only final-known speed of its own fleet [n -> 0]

//Time: O(nLog(n))       Space: O(n)
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if (n == 0) return 0;
        
        double[][] cars = new double[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double)(target - position[i]) / speed[i];
        }
        

        Arrays.sort(cars, (a, b) -> Double.compare(a[0], b[0]));
        
        int fleets = 0;
        double maxTime = 0;
        
        for (int i = n - 1; i >= 0; i--) {
            if (cars[i][1] > maxTime) {
                fleets++;
                maxTime = cars[i][1];
            }
        }
        
        return fleets;
    }
}