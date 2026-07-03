import heapq as hq

class Solution:
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        graph = {i: [] for i in range(n+1)}
        for u, v, w in times: # Directed
            graph[u].append((v, w))
        visited = set()

        time = 0
        heap = [(0, k)] # Python's heap compares tuples lexicographically
        hq.heapify(heap)

        while heap:
            curr_time, node = hq.heappop(heap)
            if node in visited: continue
            visited.add(node)
            time = max(time, curr_time)
            
            for nxt_node, nxt_time in graph[node]:
                if nxt_node in visited: continue
                hq.heappush(heap, (curr_time + nxt_time, nxt_node))
                
        return time if len(visited) == n else -1