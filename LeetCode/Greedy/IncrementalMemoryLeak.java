/// https://leetcode.com/problems/incremental-memory-leak/description/

class Solution {
    public int[] memLeak(int memory1, int memory2) {
        int i = 1;
        
        while(i <= memory1 || i <= memory2){
            if(memory1 >= memory2) 
                memory1 -= i;
            else memory2 -= i;

            ++i;
        }

        return new int[]{i, memory1, memory2};
    }
}