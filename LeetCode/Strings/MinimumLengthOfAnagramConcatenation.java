///  https://leetcode.com/problems/minimum-length-of-anagram-concatenation/description/


class Solution {
    public int minAnagramLength(String s) {
        int n = s.length();
        int[][] freq = new int[n][26];
        freq[0][s.charAt(0)-'a']++;

        for(int i=1; i<n; ++i){
            char c = s.charAt(i);

            System.arraycopy(freq[i - 1], 0, freq[i], 0, 26);

            freq[i][c-'a']++;
        }

        ArrayList<Integer> divs = new ArrayList<>(divisors(n));
        divs.sort(Comparator.comparingInt(a -> a));

        for(int div : divs){
            if(areAnagramSubarrays(freq, n, div))
                return div;
        }
        
        return n;
    }

    private boolean areAnagramSubarrays(int[][] freq, int n, int len){
        for (int i = 2; i <= n/len; i++) {
            int r = len * i - 1;
            
            for (int j = 0; j < 26; j++) {
                if(freq[r][j] - freq[r-len][j] != freq[len-1][j]) 
                    return false;
            }
        }

        return true;
    }

    public Set<Integer> divisors(int num) {
        Set<Integer> divisors = new HashSet<>();

        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                divisors.add(i);
                divisors.add(num / i);
            }
        }

        return divisors;
    }  
}