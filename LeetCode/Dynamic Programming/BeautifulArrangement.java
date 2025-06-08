///  https://leetcode.com/problems/beautiful-arrangement/description/


import java.util.AbstractMap;
class Solution {
    int n;
    private HashMap<Map.Entry<Integer,Integer>, Integer> memo = new HashMap<>();

    private int solve(int i, int mask){
        if(i > n) return 1;

        Map.Entry<Integer,Integer> entry = new AbstractMap.SimpleEntry<>(i,mask); 

        if(memo.containsKey(entry)) return memo.get(entry);

        int ans = 0;
        for(int j=1; j<=n; j++){
            if(((mask >> j) & 1) == 0 && (j % i == 0 || i % j == 0)){
                ans += solve(i+1, mask ^ (1 << j));
            }
        }

        memo.put(entry, ans);
        return ans;
    }

    public int countArrangement(int n) {
        this.n =n;
        return solve(1, 0);
    }
}