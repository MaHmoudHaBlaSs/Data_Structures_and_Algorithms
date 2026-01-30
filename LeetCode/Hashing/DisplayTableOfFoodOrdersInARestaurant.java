/// https://leetcode.com/problems/display-table-of-food-orders-in-a-restaurant/description/


class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        HashMap<String,Integer>[] mp = new HashMap[501];
        HashSet<String> foodItems = new HashSet<>();

        for(List<String> order : orders){
            int table = Integer.parseInt(order.get(1));
            if(mp[table] == null)
                mp[table] = new HashMap<>();

            var map = mp[table];
            String item = order.get(2);
            map.put(item, map.getOrDefault(item,0)+1);
            foodItems.add(item);
        }


        List<String> header = new ArrayList<>();
        foodItems.stream().sorted().forEach(header::add);
        header.addFirst("Table");
        
        List<List<String>> result = new ArrayList<>();
        result.add(header);
        
        for(int i=1; i<501; i++){
            if(mp[i] == null) continue;
            
            List<String> row = new ArrayList<>();
            row.add(String.valueOf(i));
            for(int j=1;j<header.size();j++){
                row.add(String.valueOf(mp[i].getOrDefault(header.get(j),0)));    
            }
            
            result.add(row);
        }
        return result;
    }
}