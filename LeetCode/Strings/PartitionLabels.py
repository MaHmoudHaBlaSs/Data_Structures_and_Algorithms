## https://leetcode.com/problems/partition-labels

# T: O(n)
class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        res = []
        ## Enumerate just produces pairs -> (0, 'a'), (1, 'b') [Tuples]
        last_position = {ch: i for i, ch in enumerate(s)}

        start, end = 0, 0
        for i, ch in enumerate(s):
            end = max(end, last_position[ch])

            if i == end:
                res.append(end - start + 1)
                start = i+1
                end = i+1
        
        return res