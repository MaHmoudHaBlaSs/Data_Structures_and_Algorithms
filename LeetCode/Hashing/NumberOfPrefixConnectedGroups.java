/// https://leetcode.com/problems/number-of-prefix-connected-groups/description/


class Solution {
    public int prefixConnected(String[] words, int k) {
        HashMap<String, Integer> mp = Arrays.stream(words).collect(
                HashMap::new, 
                (hashMap, s) -> {
                    if(s.length()>=k){
                        String prefix = s.substring(0, k);
                        hashMap.put(prefix, hashMap.getOrDefault(prefix, 0)+1); 
                    }
                }, 
                HashMap::putAll
            );
        
        return (int)mp.values().stream().filter(val -> val > 1).count();
    }
}