import heapq as hq

# This problem is pretty clever...
# The whole idea is about finding the optimal subgraph that contains a, b and c 
# ,optimal subgraph means the least weight.

class Solution:
    # Imagine having a vertex x that connects a ,b and c (x may be a, b or c)
    # assume we knows it so the solution would be dist(a, x) + dist(b, x) + dist(x, c)

    # Back to reality we actually don't know x, how can we find it?
    # If we know dist(a, *), dist(b, *) and dist(*, c) and we evaluate each 
    # combination to find the minimum which is the vertex and the total weight.

    # Evaluating dist(a, *) and dist(b, *) is straight forward dijkstra,
    # and to evaluate dist(*, c) you we will need to reverse all edges and applying
    # normal dijkstra dist(c, *)

    def minimumWeight(self, n: int, edges: list[list[int]], a: int, b: int, c: int) -> int:
        graph = {x: [] for x in range(n)}
        reversed_graph = {x: [] for x in range(n)}
        for u, v, w in edges:
            graph[u].append((v, w))
            reversed_graph[v].append((u, w))
        
        def dijkstra(start: int, reversed: bool = False) -> list[int]:
            costs = [float('inf') for _ in range(n)]
            heap = [(0, start)]
            
            while heap:
                cost, node = hq.heappop(heap)
                if cost > costs[node]:
                    continue
                costs[node] = cost

                for nxt_node, nxt_cost in (reversed_graph[node] if reversed else graph[node]):
                    if nxt_cost + cost > costs[nxt_node]:
                        continue
                    hq.heappush(heap, (nxt_cost + cost, nxt_node)) 

            return costs

        cost_a = dijkstra(a)    
        cost_b = dijkstra(b)    
        cost_c = dijkstra(c, True)    

        optimal = float('inf')
        for v in range(n):
            optimal = min(optimal, cost_a[v] + cost_b[v] + cost_c[v])

        return optimal if optimal != float('inf') else -1