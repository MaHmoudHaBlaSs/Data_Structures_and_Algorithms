# https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance

import heapq as hq

class Solution:
    def findTheCity(self, n: int, edges: list[list[int]], threshold: int) -> int:
        graph = [[] for _ in range(n)]
        for u, v, w in edges:
            graph[u].append((v, w))
            graph[v].append((u, w))

        def dijkstra(start):
            cities = -1
            heap = [(0, start)]
            visited = [False for _ in range(n)]

            while heap:
                cum_w, u = hq.heappop(heap)
                if visited[u]:
                    continue
                visited[u] = True
                cities += 1
                for v, w in graph[u]:
                    if visited[v] or cum_w + w > threshold:
                        continue
                    hq.heappush(heap, (cum_w + w, v))

            return cities


        min_cities = float('inf')
        city = -1
        
        for node in range(n):
            cities = dijkstra(node)

            if cities <= min_cities:
                min_cities = cities
                city = node
        
        return city