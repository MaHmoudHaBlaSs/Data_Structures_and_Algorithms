/// https://leetcode.com/problems/count-of-substrings-containing-every-vowel-and-k-consonants-ii/description/

class Solution {
    public long countOfSubstrings(String word, int k) {
        return countAtLeast(word, k) - countAtLeast(word, k + 1);
    }

    private long countAtLeast(String word, int k) {
        int n = word.length();

        long ans = 0;

        int[] freq = new int[5];
        int distinctVowels = 0;
        int consonants = 0;

        int left = 0;

        for (int right = 0; right < n; right++) {
            char c = word.charAt(right);

            int idx = vowelIndex(c);

            if (idx >= 0) {
                if (freq[idx]++ == 0) {
                    distinctVowels++;
                }
            } else {
                consonants++;
            }

            while (distinctVowels == 5 && consonants >= k) {
                ans += n - right;

                char remove = word.charAt(left++);
                int removeIdx = vowelIndex(remove);

                if (removeIdx >= 0) {
                    if (--freq[removeIdx] == 0) {
                        distinctVowels--;
                    }
                } else {
                    consonants--;
                }
            }
        }

        return ans;
    }

    private int vowelIndex(char c) {
        switch (c) {
            case 'a': return 0;
            case 'e': return 1;
            case 'i': return 2;
            case 'o': return 3;
            case 'u': return 4;
            default: return -1;
        }
    }
}
