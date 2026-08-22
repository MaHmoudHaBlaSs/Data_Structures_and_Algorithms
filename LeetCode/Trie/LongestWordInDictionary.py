# https://leetcode.com/problems/longest-word-in-dictionary

# Time: O(n.log(n) * O(n.m)) , n is words and m is the max length of a word.
# Space: O(n)
class Solution:
    def longestWord(self, words: list[str]) -> str:
        words.sort(key=len)
        words_set = set()
        res = ''
        
        for word in words:
            is_valid = True
            for i in range(len(word)-1, 0, -1):
                if word[:i] not in words_set:
                    is_valid = False
                    break

            if is_valid:
                if len(word) > len(res):
                    res = word
                elif len(word) == len(res):
                    res = res if res < word else word

            words_set.add(word)

        return res

    