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