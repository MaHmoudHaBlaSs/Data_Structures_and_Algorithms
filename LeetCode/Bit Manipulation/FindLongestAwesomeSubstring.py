# https://leetcode.com/problems/find-longest-awesome-substring/description/


class Solution:
    def longestAwesome(self, s: str) -> int:
        n = len(s)
        mask, ans = 0, 0
        firstOccurrence = {0: -1}
        
        for i in range(n):
            mask ^= (1 << (ord(s[i]) - ord('0')))

            if mask in firstOccurrence:
                ans = max(ans, i - firstOccurrence[mask])
            else:
                firstOccurrence[mask] = i
            
            for j in range(10):
                needed = mask ^ (1 << j)
                if needed in firstOccurrence:
                    ans = max(ans, i - firstOccurrence[needed])
        
        return ans