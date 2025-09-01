/// https://leetcode.com/problems/finding-the-users-active-minutes/description/

class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] ans = new int[k];
        HashMap<Integer, HashSet<Integer>> UAM = new HashMap<>();

        for(int[] log : logs){
            UAM.putIfAbsent(log[0], new HashSet<>());
            UAM.get(log[0]).add(log[1]);
        }

        for(var minutes : UAM.values()){
            if(!minutes.isEmpty())
                ans[minutes.size()-1]++;
        }

        return ans;
    }
}