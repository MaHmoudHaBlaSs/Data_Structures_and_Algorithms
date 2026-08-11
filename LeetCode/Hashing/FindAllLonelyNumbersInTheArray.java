/// https://leetcode.com/problems/find-all-lonely-numbers-in-the-array/description/


class Solution {
    public List<Integer> findLonely(int[] nums) {
        HashMap<Integer, Integer> mp = new HashMap<>();

        for(int num : nums){
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }

        List<Integer> ans = new ArrayList<>();
        for(var entry : mp.entrySet()){
            if(entry.getValue() == 1){
                int adj1 = entry.getKey() - 1, adj2 = adj1 + 2;
                
                if(!mp.containsKey(adj1) && !mp.containsKey(adj2))
                    ans.add(entry.getKey());
            }
        }

        
        return ans;
    }
}