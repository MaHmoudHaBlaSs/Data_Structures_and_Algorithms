#  https://leetcode.com/problems/magnetic-force-between-two-balls/description/


class Solution:
    def maxDistance(self, position: List[int], m: int) -> int:
        position.sort()
        n = len(position)

        def canDistribute(minForce: int) -> bool:
            i=1
            distributed, prev = 1, position[0]

            while i < n:
                if position[i] - prev >= minForce:
                    distributed += 1
                    prev = position[i]

                    if distributed == m: 
                        return True
                i += 1

            return False
        
        l, r = 1, (position[n-1] - position[0])//(m-1)
        ans = l

        while l <= r:
            mid =  (l+r) >> 1

            if canDistribute(mid):
                ans = mid
                l = mid + 1
            else: 
                r = mid - 1

        return ans