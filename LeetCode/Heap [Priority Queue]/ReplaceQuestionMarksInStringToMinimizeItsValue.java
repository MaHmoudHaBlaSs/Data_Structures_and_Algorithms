/// https://leetcode.com/problems/replace-question-marks-in-string-to-minimize-its-value/description/

class Solution {
    public String minimizeStringValue(String s) {
        int[] freq = new int[26];
        StringBuilder sb = new StringBuilder();
        int marks = 0;

        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch != '?') freq[ch-'a']++;
            else marks++;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) ->{
            if(a[1] != b[1]) return a[1] - b[1];

            return a[0]-b[0];
        });

        for (int i = 0; i < 26; i++) {
            pq.add(new int[]{i, freq[i]});
        }
        Arrays.fill(freq,0);

        for (int i = 0; i < marks; i++) {
            int[] top = pq.poll();
            freq[top[0]]++;
            top[1]++;
            pq.add(top);
        }
        
        int idx = 0;
        for (int i = 0; i < s.length(); i++) {
            while (idx <26 && freq[idx] == 0) idx++;
            
            if(s.charAt(i) == '?'){
                sb.append((char)(idx+'a'));
                freq[idx]--;
            }else{
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}