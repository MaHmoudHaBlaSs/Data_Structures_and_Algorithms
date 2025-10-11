## https://leetcode.com/problems/most-popular-video-creator


# Time: O(nlog(n))    S: O(n)
class Solution:
    def mostPopularCreator(self, creators: List[str], ids: List[str], views: List[int]) -> List[List[str]]:
        import heapq as hq
        from dataclasses import dataclass, field

        @dataclass(order = True)
        class heap_obj:
            creator: str = field(compare = False)
            id: int = field(compare = False)
            sum: int

        map = {}
        res = []

        for creator, film, view in zip(creators, ids, views):
            if creator in map:
                info = map[creator]
                info[2] += view
                
                if view > info[1]:
                    info[0] = film
                    info[1] = view

                elif view == info[1]:
                    if film < info[0]:
                        info[0] = film
            else:
                map[creator] = [film, view, view]
        
        max_heap = []
        for k, v in map.items():
            hq.heappush(max_heap, heap_obj(k, v[0], -v[2]))

        popped = max_heap[0]
        while max_heap and popped.sum == max_heap[0].sum:
            popped = hq.heappop(max_heap)
            res.append([popped.creator, popped.id])
        
        return res