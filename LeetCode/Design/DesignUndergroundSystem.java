///  https://leetcode.com/problems/design-underground-system/description/

class UndergroundSystem {
    HashMap<Integer, HashMap<String, Integer>> startMap = new HashMap<>();
    HashMap<String, HashMap<String, int[]>> avgMap = new HashMap<>();

    public UndergroundSystem() {

    }

    public void checkIn(int id, String stationName, int t) {
        startMap.computeIfAbsent(id, (k) -> new HashMap<>())
                .put(stationName, t);
    }

    public void checkOut(int id, String stationName, int t) {
        Map.Entry<String, Integer> entry = startMap.remove(id).entrySet().stream().findFirst().get();

        int[] arr = avgMap.computeIfAbsent(entry.getKey(), k -> new HashMap<>())
                .computeIfAbsent(stationName, k-> new int[]{0,0});

        arr[0] += t- entry.getValue();
        arr[1]++;
    }

    public double getAverageTime(String startStation, String endStation) {
        int[] arr = avgMap.get(startStation).get(endStation);
        return (double)arr[0]/arr[1];
    }
}