// https://leetcode.com/problems/find-the-most-common-response/description/


class Solution {
    public String findCommonResponse(List<List<String>> responses) {
        Map<String,Integer> countMap = new HashMap();
        String res = "" ;
        int max = 0;
        for(List<String> response : responses){
            Set<String> set = new HashSet();
            for(String s : response){
                if(!set.contains(s)){
                    
                    int freq = countMap.getOrDefault(s , 0) + 1;
                    countMap.put(s , freq);
                    set.add(s);
                    
                    if( max<freq ||  (max==freq && s.compareTo(res) < 0) ){
                        res = s;
                        max = freq;
                    }
                }
            }
        }
        return res;
    }
}