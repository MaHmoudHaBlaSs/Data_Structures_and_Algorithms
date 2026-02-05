///  https://leetcode.com/problems/number-of-ways-to-wear-different-hats-to-each-other/description/


class Solution {
    private static final long MOD = 1_000_000_007L;
    private HashMap<Integer, Integer>[] memo = new HashMap[1025];

    private int ways(int personMask, List<List<Integer>> hats, int avHats){
        if(personMask == 0) return 1;

        if(memo[personMask].containsKey(avHats)) 
            return memo[personMask].get(avHats);

        int person = ;
        long ans = 0;
        for (int i = 0; i < hats.size(); i++) {
            if((personMask & (1 << i)) != 0){
                person = i;
                for(int hat : hats.get(person)){
                    if(hat <= avHats)
                        ans = (ans + ways(personMask ^ (1 << person), hats, hat - 1)) % MOD;
                }
            }
        }

        memo[personMask].put(avHats, (int)ans);
        return (int)ans;
    }

    public int numberWays(List<List<Integer>> hats) {
        for (int i = 0; i < 1025; i++) {
            memo[i] = new HashMap<>();
        }
        
        int mask = 0; 
        for (int i = 0; i < hats.size(); i++) {
            mask |= 1 << i;
        }
        return ways(mask, hats, 40);
    }
}