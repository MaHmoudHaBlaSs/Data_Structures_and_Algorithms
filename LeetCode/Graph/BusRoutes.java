// https://leetcode.com/problems/bus-routes/description

class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if ( source == target ) return 0;
        Map<Integer, List<Integer>> stops = new HashMap<>();

        for (int i = 0; i < routes.length; i++){
            for (int j = 0; j < routes[i].length; j++){
                int stop = routes[i][j];

                if ( !stops.containsKey(stop) )
                    stops.put(stop, new LinkedList<>(List.of(i))); // bus
                else
                    stops.get(stop).add(i);
            }
        }

        if (!stops.containsKey(source) || !stops.containsKey(target))
            return -1;
            
        Queue<int[]> queue = new LinkedList<>(); // bus, res (how many buses)
        Set<Integer> visited = new HashSet<>(); // bus

        for (int bus: stops.get(source)) {
            queue.add(new int[]{bus, 1});
            visited.add(bus);
        }

        while (!queue.isEmpty()){
            int[] currBus = queue.poll();

            for ( int route: routes[currBus[0]]){
                if (route == target)
                    return currBus[1];

                for ( int nextBus: stops.get(route) ){
                    if (visited.contains(nextBus))
                        continue;
                    visited.add(nextBus);
                    
                    queue.add(new int[]{nextBus, currBus[1] + 1});
                }
            }
        }
        return -1;
    }
}


class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {

        Map <Integer, List<Integer>> stopsGraph = new HashMap<>(); // stop -> buses
        for (int bus = 0; bus < routes.length; bus++) {
            for (int stop : routes[bus]) {
                if ( !stopsGraph.containsKey(stop) )
                    stopsGraph.put(stop, new LinkedList<>(List.of(bus))); 
                else
                    stopsGraph.get(stop).add(bus);
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visitedStops = new HashSet<>();
        Set<Integer> visitedBuses = new HashSet<>();
        queue.offer(source);
        visitedStops.add(source);
        int busesTaken = 0; 
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                int currentStop = queue.poll();
                if (currentStop == target) return busesTaken;

                for (int bus : stopsGraph.getOrDefault(currentStop, new LinkedList<>())) {
                    if (!visitedBuses.contains(bus)) {
                        visitedBuses.add(bus);
                        for (int nextStop : routes[bus]) {
                            if (!visitedStops.contains(nextStop)) {
                                visitedStops.add(nextStop);
                                queue.offer(nextStop);
                            }
                        }
                    }
                }
                
            }
            busesTaken++;
        }
        return -1;
    }
}