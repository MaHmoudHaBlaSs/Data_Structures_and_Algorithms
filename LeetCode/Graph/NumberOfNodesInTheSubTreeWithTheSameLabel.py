#  https://leetcode.com/problems/number-of-nodes-in-the-sub-tree-with-the-same-label/description/

class Solution:
    def countSubTrees(self, n: int, edges: List[List[int]], labels: str) -> List[int]:
        adj = [[] for _ in range(n)]
        for a,b in edges: 
            adj[a].append(b)
            adj[b].append(a)

        ans = [0] * n

        def dfs(v: int, parent: int) -> List[int]:
            freq = [0] * 26

            for child in adj[v]:
                if child == parent: continue
                childFreq = dfs(child, v)
                for i in range(26):
                    freq[i] += childFreq[i]
                    
            idx = ord(labels[v]) - ord('a')
            freq[idx] += 1
            ans[v] = freq[idx]

            return freq
        
        dfs(0,-1)
        return ans