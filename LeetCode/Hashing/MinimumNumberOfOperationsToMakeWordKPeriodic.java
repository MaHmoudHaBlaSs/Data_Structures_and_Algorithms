///   https://leetcode.com/problems/minimum-number-of-operations-to-make-word-k-periodic/description/

class Solution {
    public int minimumOperationsToMakeKPeriodic(String word, int k) {
        int n = word.length();
        HashMap<String, Integer> mp = new HashMap<>();
        String str = "";
        int maxFreq = 0;

        for(int i=0; i<n; ++i){
            str += word.charAt(i);

            if((i+1)%k == 0){
                int freq = mp.getOrDefault(str, 0)+1;

                mp.put(str, freq);
                str = "";
                maxFreq = Integer.max(maxFreq, freq);
            }
        }

        return (n/k) - maxFreq;
    }
}