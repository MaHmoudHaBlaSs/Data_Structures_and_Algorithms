///    https://leetcode.com/problems/design-ride-sharing-system/description/


class RideSharingSystem {
    private LinkedHashSet<Integer> riders = new LinkedHashSet<>();
    private ArrayDeque<Integer> drivers = new ArrayDeque<>();

    public RideSharingSystem() {
        
    }
    
    public void addRider(int riderId) {
        riders.addLast(riderId);  
    }
    
    public void addDriver(int driverId) {
        drivers.addLast(driverId);
    }
    
    public int[] matchDriverWithRider() { 
        if(drivers.isEmpty() || riders.isEmpty()){
            return new int[]{-1, -1};
        }

        return new int[]{drivers.removeFirst(), riders.removeFirst()};
    }
    
    public void cancelRider(int riderId) {
        riders.remove(riderId);
    }
}