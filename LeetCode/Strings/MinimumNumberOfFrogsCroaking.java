///  https://leetcode.com/problems/minimum-number-of-frogs-croaking/description/


class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {
        int n = croakOfFrogs.length();
        if(n%5 != 0) return -1; 
        
        int[] freq = new int[5]; 
        HashMap<Character, Integer> mp = new HashMap<>();
        String str = "croak";

        for(int i=0; i<5; ++i) {
            mp.put(str.charAt(i),i);
        }

        int ans = 1;
        for(int i=0; i<n; ++i){
            int idx = mp.get(croakOfFrogs.charAt(i));

            if(idx > 0 && freq[idx-1] <= freq[idx]) return -1;

            ++freq[idx];
            ans = Math.max(ans, freq[0]-freq[4]);
        }

        for(int i=1; i<5; ++i) {
            if(freq[i] != freq[0]) return -1; 
        }

        return ans;
    }
}