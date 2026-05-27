///  https://leetcode.com/problems/count-caesar-cipher-pairs/description/

class Solution {
    public long countPairs(String[] words) {
        HashMap<String, Integer> mp = new HashMap<>();
        long ans = 0;

        for(String word: words){
            StringBuilder sb = new StringBuilder();

            int diff = word.charAt(0)-'a';
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if(diff > ch-'a')
                    sb.append((char)(ch-diff+26));
                else
                    sb.append((char)(ch-diff));
            }

            String st = sb.toString();
            int c = mp.getOrDefault(st,0);
            mp.put(st, c+1);
            
            ans += c;
        }

        return ans;
    }
}