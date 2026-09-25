# https://leetcode.com/problems/minimum-cost-to-convert-string-i

# Instead of finding the shortest path from one source to all other vertices (like Dijkstra),
# Floyd–Warshall pre-computes the shortest distance between every pair of vertices.

# It is the preferred choice when you need the shortest distances between every pair of vertices,
# especially for small to medium-sized dense graphs like the following problem just 26 nodes at most.

class Solution:
    def minimumCost(self, source: str, target: str, original: list[str], changed: list[str], cost: list[int]) -> int:

        INF = 10**18
        def index(char):
            return ord(char) - ord('a')
        

        costs_arr = [[INF if i!= j else 0 for i in range(26)] for j in range(26)]
        
        for i in range(len(original)):
            costs_arr[ index(original[i]) ][ index(changed[i]) ] = min(
                costs_arr[ index(original[i]) ][ index(changed[i]) ],
                cost[i]) # may have 2 transitions a -> b: 6 and a -> b: 2

        # O(26 ^ 3) => O(1)
        for k in range(26):
            for i in range(26):
                for j in range(26):
                    costs_arr[i][j] = min(costs_arr[i][j], costs_arr[i][k] + costs_arr[k][j])
              
        min_cost = 0
        for i in range(len(source)):
            min_cost += costs_arr[ index(source[i]) ][ index(target[i]) ]

        return min_cost if min_cost < INF else -1