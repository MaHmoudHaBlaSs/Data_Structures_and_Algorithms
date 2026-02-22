///  https://leetcode.com/problems/avoid-flood-in-the-city/description/

class Solution {
    public int[] avoidFlood(int[] rains) {
        HashMap<Integer, Integer> lakeLastRain = new HashMap<>();
        int[] ans = new int[rains.length];

        TreeSet<Integer> emptyDays = new TreeSet<>();
        for(int i = 0; i < rains.length; i++){
            if(rains[i] == 0){
                emptyDays.add(i);
                ans[i] = 1;
            }
            else ans[i] = -1; 
        }

        int idx = 0;
        for(int day = 0; day < rains.length; day++){
            if(rains[day] == 0) continue;
            
            if(lakeLastRain.containsKey(rains[day])) {
                int lastRain = lakeLastRain.get(rains[day]);
                Integer empty = emptyDays.ceiling(lastRain);
                
                if(empty == null || empty > day) return new int[0];
                
                emptyDays.remove(empty);
                ans[empty] = rains[day];
            }
            
            lakeLastRain.put(rains[day], day);
        }

        return ans;
    }
}