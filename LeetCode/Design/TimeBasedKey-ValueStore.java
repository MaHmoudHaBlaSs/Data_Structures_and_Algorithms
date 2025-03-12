// https://leetcode.com/problems/time-based-key-value-store/description/

// Optimal Approach
class TimeMap {
    // S: O(n*m) >> n = keys, m = timestamps, Max = (10^9)[100 * 10^7]
    Map<String , List<Pair<Integer, String>>> map;

    public TimeMap() {
        map = new HashMap<>(); // S: O(n)
    }
    
    // T: ~~ O(1)    S: O(1)
    public void set(String key, String value, int timestamp) {
        if (map.containsKey(key)){
            map.get(key).add(new Pair<Integer, String>(timestamp, value));
        }
        else{
            List<Pair<Integer, String>> list = new ArrayList<>();
            list.add(new Pair<Integer, String>(timestamp, value));
            map.put(key, list);
        }
    }
    
    // T: O(log(n))     S: O(1)
    public String get(String key, int timestamp) {
        if (map.containsKey(key)){
            List<Pair<Integer, String>> list = map.get(key);
            int left = 0, right = list.size()-1;
            if ( timestamp < list.get(0).timestamp) return "";
            if (timestamp > list.get(right).timestamp) return list.get(right).value;
            
            while (left <= right){
                int mid = (left+right)/2;

                if (list.get(mid).timestamp > timestamp) right = mid-1;
                else if (list.get(mid).timestamp < timestamp) left = mid+1;
                else return list.get(mid).value;
            }
            return list.get(right).value;
        }
        return "";
    }

    private static class Pair <T, E> {
        T timestamp;
        E value;
        public Pair(T ts, E val){
            this.timestamp = ts;
            this.value = val;
        }
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
