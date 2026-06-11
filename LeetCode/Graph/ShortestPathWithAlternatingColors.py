# https://leetcode.com/problems/shortest-path-with-alternating-colors

from collections import deque

class Solution:
    def shortestAlternatingPaths(self, n: int, redEdges: List[List[int]], blueEdges: List[List[int]]) -> List[int]:
        graph = [[] for _ in range(n)]

        for edge in redEdges:
            graph[edge[0]].append((edge[1], 'R'))

        for edge in blueEdges:
            graph[edge[0]].append((edge[1], 'B'))

        lengths = [-1 for _ in range(n)]
        lengths[0] = 0
        visited = set()
        
        q = deque(graph[0])
        level = 0

        while q:
            level += 1
            for _ in range(len(q)):
                target, color = q.popleft()
                
                if (target, color) in visited:
                    continue
                visited.add((target, color))
                
                if lengths[target] == -1 and target != 0:
                    lengths[target] = level

                q.extend([ edge for edge in graph[target] if edge[1] != color])

        return lengths