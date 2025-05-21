///    https://leetcode.com/problems/frog-jump/description/

/*
Making integer 2D array can't will exceed the memory limit.
State: 
    dp[i][jump] is true if the frog can get the last stone when he stands at stone[i] && the last k = 'jmup'
*/

class Solution {
    private HashMap<Key, Boolean> dp = new HashMap<>();
    private int[] stones;
    private int n;
    
    private boolean can(int i, int jump){
        if(i == n-1) return true;
        
        Key newKey = new Key(i,jump);
        if(dp.containsKey(newKey)) return dp.get(newKey);
        
        boolean flag = false;
        int j = i+1;
        while (j < n && !flag && stones[j] <= stones[i] + jump + 1){
            if(stones[j] == stones[i] + jump - 1) 
                flag = can(j, jump -1);             
            
            if(stones[j] == stones[i] + jump) 
                flag = flag || can(j, jump);             
            
            if(stones[j] == stones[i] + jump+1) 
                flag = flag || can(j, jump+1);

            j++;
        }
        
        dp.put(newKey, flag);
        return flag;
    }
    
    public boolean canCross(int[] stones) {
        this.stones = stones;
        n = stones.length;
        return can(0,0);
    }


    private class Key{
        int index,jump;
        Key(int index, int jump){
            this.index = index;
            this.jump = jump;
        }

        @Override
        public int hashCode(){
            return index + jump;
        }

        @Override
        public boolean equals(Object object){
            Key casted = (Key)object;
            return this.index == casted.index && this.jump == casted.jump;
        }
    }
}