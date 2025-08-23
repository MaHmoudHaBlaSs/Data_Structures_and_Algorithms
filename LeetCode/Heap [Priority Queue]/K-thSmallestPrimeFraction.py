# https://leetcode.com/problems/k-th-smallest-prime-fraction

from dataclasses import dataclass, field

class Solution:
    
    @dataclass(order = True)
    class Fraction:
        i: int = field(compare = False)
        j: int = field(compare = False)
        fract: float = field(compare = True)

    def kthSmallestPrimeFraction(self, arr: List[int], k: int) -> List[int]:
        min_heap = []
        
        for i in range(len(arr)):
            for j in range(i+1, len(arr)):
                heapq.heappush(min_heap, self.Fraction(arr[i], arr[j], arr[i]*1.0 / arr[j]))

        while k > 1:
            k -= 1
            heapq.heappop(min_heap)
        
        res = heapq.heappop(min_heap) 
        return [res.i, res.j]
            