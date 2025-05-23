// https://leetcode.com/problems/sort-characters-by-frequency/description/

// T: O(nlog(n))                S: O(n)
class Solution {
    class Pair implements Comparable<Pair>{
        char ch;
        int freq;
        public Pair(char c, int f){
            this.ch = c;
            this.freq = f;
        }

        @Override
        public int compareTo(Pair other){
            return Integer.compare(other.freq, this.freq); // to make it sort Decreasingly
        }
    }
    public String frequencySort(String s) {
        Map<Character, Integer> freq = new HashMap();
        StringBuilder res = new StringBuilder();
        
        for (char ch: s.toCharArray())
            freq.put(ch , freq.getOrDefault(ch, 0)+1);

        int i = 0;
        Pair[] pairs = new Pair[freq.size()];

        for (var entry: freq.entrySet())
            pairs[i++] = new Pair(entry.getKey(), entry.getValue());
        
        Arrays.sort(pairs);
        for (Pair pair: pairs){
            for (int j = pair.freq; j > 0; j--) 
                res.append(pair.ch);
        }

        return res.toString();
    }
}