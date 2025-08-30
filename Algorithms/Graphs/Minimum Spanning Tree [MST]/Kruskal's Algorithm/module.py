from dataclasses import dataclass, field
import heapq
from typing import List


@dataclass(order =True)
class Edge:
    source: int = field(compare = False)
    target: int = field(compare = False)
    weight: int

def kruskal(edges, n) -> List[Edge]:
    def get_parent(lst, i):
        while lst[i] >= 0: i = lst[i]
        return i

    mst = []
    union = [-1 for _ in range(n)]
    min_heap = []

    for edge in edges:
        heapq.heappush(min_heap, edge)

    while min_heap:
        min_edge = heapq.heappop(min_heap)
        source_parent = get_parent(union, min_edge.source)
        target_parent = get_parent(union, min_edge.target)

        if source_parent == target_parent: continue

        if union[source_parent] <= union[target_parent]:
            union[source_parent] += union[target_parent]
            union[target_parent] = source_parent
        else:
            union[target_parent] += union[source_parent]
            union[source_parent] = target_parent
        mst.append(min_edge)

    return mst

edges = [
    Edge(0, 1, 4),
    Edge(0, 7, 8),
    Edge(1, 2, 8),
    Edge(1, 7, 11),
    Edge(2, 3, 7),
    Edge(2, 5, 4),
    Edge(2, 8, 2),
    Edge(3, 4, 9),
    Edge(3, 5, 14),
    Edge(4, 5, 10),
    Edge(5, 6, 2),
    Edge(6, 7, 1),
    Edge(6, 8, 6),
    Edge(7, 8, 7)
]

mst = kruskal(edges, 9)
for edge in mst:
    print(f'Edge: {edge.source} -> {edge.target} = {edge.weight}')