## https://leetcode.com/problems/reorganize-string

import heapq as hq
from dataclasses import dataclass, field

class Solution:
    # Greedy: Time O(n) | Space O(1)
    from collections import Counter
    def reorganizeString(self, s: str) -> str:
        n = len(s)
        freqs = Counter(s)
        res = ['' for _ in range(len(s))]
        master = freqs.most_common(1)[0]

        if master[1] > ((n + 1) // 2):
            return ''


        idx = 0
        for _ in range(master[1]):
            res[idx] = master[0]
            idx += 2

        del freqs[master[0]]

        for char, freq in freqs.items():
            for _ in range(freq):
                if idx >= n: # when evens exceded go to odds
                    idx = 1
                res[idx] = char
                idx += 2
        return ''.join(res)
# ----------------------------------------------------------------------------------------- #

    # Greedy + Max Heap: Time O (n log(k)) | Space O(k) >> k is unique chars
    import heapq as hq
    from dataclasses import dataclass, field
    def reorganizeString(self, s: str) -> str:

        @dataclass
        class Pair:
            ch: str = field(compare = False)
            freq: int = field(compare = True) # try to remove

            def __lt__(self, other):
                return other.freq < self.freq

        freq_map = {}
        for char in s:
            freq_map[char] = freq_map.get(char, 0) + 1

        max_heap = [Pair(k, v) for k, v in freq_map.items()]
        hq.heapify(max_heap)

        organized = []
        prev = None
        while max_heap:
            if prev is None and len(max_heap) == 1 and max_heap[0].freq > 1:
                return ''

            popped = hq.heappop(max_heap)
            organized.append(popped.ch)

            if prev is not None:
                hq.heappush(max_heap, prev)
                prev = None
            
            if popped.freq > 1:
                popped.freq -= 1
                prev = popped

        return "".join(organized)