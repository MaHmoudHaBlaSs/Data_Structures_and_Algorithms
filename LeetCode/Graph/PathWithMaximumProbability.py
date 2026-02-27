#  https://leetcode.com/problems/path-with-maximum-probability/description/

class Solution:
    def maxProbability(self, n: int, edges: List[List[int]], succProb: List[float], start_node: int, end_node: int) -> float:
        adj = [[] for i in range(n)]
        
        for i, (u,v) in enumerate(edges):
            adj[u].append((v, succProb[i]))
            adj[v].append((u, succProb[i]))


        # dijkstra 
        prob = [0] * n
        prob[start_node] = 1
        
        pq = []
        heapq.heappush(pq, (-1, start_node))
        

        while pq:
            (nodeProb, node) = heapq.heappop(pq)
            nodeProb *= -1

            if nodeProb < prob[node]: continue

            for (u, p) in adj[node]:
                newProb = nodeProb * p
                
                if prob[u] < newProb:
                    heapq.heappush(pq, (-newProb, u))
                    prob[u] = newProb



        return prob[end_node]
        