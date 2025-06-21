///  https://leetcode.com/problems/minimum-deletions-to-make-string-k-special/description/


class Solution {
    public int minimumDeletions(String word, int k) {
        int[] freq = new int[26];
        for(char c : word.toCharArray())
            freq[c-'a']++;

        Arrays.sort(freq);
        int ans = 100_000, prev = 0;

        for (int i = 0; i < 26; i++) {
            int toBeRemoved = prev;

            int j = i+1;
            while(j < 26) toBeRemoved +=  Math.max(0,freq[j++] - freq[i]-k);

            ans = Math.min(ans, toBeRemoved);
            prev += freq[i];
        }

        return ans;
    }
}