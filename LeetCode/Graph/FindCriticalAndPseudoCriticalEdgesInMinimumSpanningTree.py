#  https://leetcode.com/problems/find-critical-and-pseudo-critical-edges-in-minimum-spanning-tree/description/

class Solution:
    def findCriticalAndPseudoCriticalEdges(self, n: int, edges: List[List[int]]) -> List[List[int]]:
        new_edges = []
        for i in range(len(edges)): new_edges.append(edges[i] + [i])

        new_edges.sort(key=lambda edge : edge[2])

        mst_weight = self._mst(n, new_edges, -1, -1)
        critical = []
        pseudo = []

        for i in range(len(new_edges)):
            if self._mst(n, new_edges, skip=i, enforce=-1) != mst_weight:
                critical.append(new_edges[i][3])
            elif self._mst(n, new_edges, skip=-1, enforce=i) == mst_weight:
                pseudo.append(new_edges[i][3])

        return [critical, pseudo];        

    def _mst(self, n, edges, skip, enforce) -> int:
        uf = UnionFind(n)
        weight: int = 0

        if enforce >= 0: 
            u, v, w, _ = edges[enforce]
            uf.union(u,v)
            weight = w

        for i, (u,v,w,_) in enumerate(edges):
            if i == skip: continue
            if uf.union(u,v): weight += w
        
        return weight


class UnionFind:
    def __init__(self, n):
        self.parent = list(range(n))
    
    def find(self, x):
        if self.parent[x] != x:
            self.parent[x] = self.find(self.parent[x]) 
        return self.parent[x]
    
    def union(self, a, b):
        ra, rb = self.find(a), self.find(b)
        
        if ra == rb: return False
        
        self.parent[ra] = rb
        return True