///  https://leetcode.com/problems/count-good-meals/description/

class Solution {
    public int countPairs(int[] deliciousness) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int num : deliciousness)
            freq.put(num, freq.getOrDefault(num, 0) + 1);

        long ans = 0, mod = 1000_000_007;
        for(var entry : freq.entrySet()){
            int num = entry.getKey(), f = entry.getValue();
            int multipleOf2 = 1; 
            
            for(int i=0; i<23; ++i){
                int diff = multipleOf2 - num;
                if(diff >= num){                    
                    if(diff != num){
                        ans = (ans + (long) f * freq.getOrDefault(diff, 0)) % mod;
                    }else if(f > 1){
                        ans = (ans + ((long)f * (f-1) / 2L)) % mod;
                    }
                }
                multipleOf2 <<= 1;
            }
        }
        
        return (int)ans;
    }
}