/// https://leetcode.com/problems/top-k-frequent-words/description/


class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> mp = Arrays
                .stream(words)
                .collect(
                    HashMap::new, 
                    (map,str) -> map.put(str, map.getOrDefault(str,0)+1), 
                    HashMap::putAll
                );

        PriorityQueue<String> pq = new PriorityQueue<>((str1, str2) -> {
            int freq1 = mp.get(str1), freq2 = mp.get(str2); 
            if(freq1 != freq2) 
                return freq1 - freq2;
            
            return str2.compareTo(str1);  
        });
        
        for(var word : mp.keySet()){
            pq.add(word); 
            if(pq.size() > k) pq.poll();
        }
        
        List<String> ans = new ArrayList<>(k);
        while(!pq.isEmpty()) ans.add(pq.poll());
        
        return ans.reversed();
    }
}