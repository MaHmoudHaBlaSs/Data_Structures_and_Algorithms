# https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance

from dataclasses import dataclass, field
import sys
import heapq

class Solution:
    def findTheCity(self, n: int, edges: List[List[int]], distanceThreshold: int) -> int:
        
        @dataclass
        class Edge:
            target: int
            weight: int

        @dataclass(order = True)
        class Node:
            vertex: int = field(compare = False)
            cost: int


        graph = [[] for _ in range(n)]
        city = -1
        min_cities = sys.maxsize

        for edge in edges:
            graph[edge[0]].append(Edge(edge[1], edge[2]))
            graph[edge[1]].append(Edge(edge[0], edge[2]))


        def dijkstra(graph: List, n, start, max_cost):
            cities = 0
            costs = [sys.maxsize for _ in range(n)]

            min_heap = []
            heapq.heappush(min_heap, Node(start, 0))
            costs[start] = 0

            while min_heap:
                min_node = heapq.heappop(min_heap)

                for road in graph[min_node.vertex]:
                    target_cost = min_node.cost + road.weight

                    if target_cost < costs[road.target] and target_cost <= max_cost:

                        cities += 1 if costs[road.target] > max_cost else 0
                        costs[road.target] = target_cost

                        if target_cost < max_cost:
                            heapq.heappush(min_heap, Node(road.target, target_cost))
            
            return cities

        for i in range(n):
            cities = dijkstra(graph, n, i, distanceThreshold)

            if cities <= min_cities:
                city = i
                min_cities = cities

        return city