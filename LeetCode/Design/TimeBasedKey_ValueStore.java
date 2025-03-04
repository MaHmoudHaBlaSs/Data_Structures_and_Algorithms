// https://leetcode.com/problems/time-based-key-value-store/description/

class TimeMap {
    // S: O(n*m) >> n = keys, m = timestamps, Max = (10^9)[100 * 10^7]
    HashMap<String, List<Pair>> map = new HashMap<>();

    public TimeMap() {
        
    }
    
    // T: O(1)           S: O(1)
    public void set(String key, String value, int timestamp) {
        if (map.containsKey(key)){
            // Add time stamp
            map.get(key).add(new Pair(timestamp, value));
        }
        else{
            // Create new key with list
            List<Pair> list = new ArrayList<>();
            list.add(new Pair(timestamp, value));
            map.put(key, list);
        }
    }
    
    // T: O(Log(n))      S: O(m) , m > timestamps
    public String get(String key, int timestamp) {
        if (map.containsKey(key)){
            List<Pair> list = map.get(key);
            int left = 0, right = list.size()-1;
            
            // O(Log(n))
            while (left <= right){
                int mid = (left+right)/2;

                if (list.get(mid).getKey() > timestamp)
                    right = mid-1;
                else if (list.get(mid).getKey() < timestamp)
                    left = mid+1;
                else
                    return list.get(mid).getValue();
            }
            return (right >= 0)? list.get(right).getValue(): "";
        }
        return "";
    }
    private static class Pair{
        int key;
        String value;
        public Pair(int k, String v){
            key = k;
            value = v;
        }
        public int getKey() { return key; }
        public String getValue() { return value; }
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
