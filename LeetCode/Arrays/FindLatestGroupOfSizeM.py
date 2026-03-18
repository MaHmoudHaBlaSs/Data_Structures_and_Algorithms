#  https://leetcode.com/problems/find-latest-group-of-size-m/description/


class Solution:
    def findLatestStep(self, arr: List[int], m: int) -> int:
        n = len(arr)
        if m == n:
            return n

        length = [0] * (n + 2)
        count = [0] * (n + 1)

        res = -1

        for step, x in enumerate(arr):
            left = length[x - 1]
            right = length[x + 1]

            new_len = left + right + 1

            length[x - left] = new_len
            length[x + right] = new_len

            count[left] -= 1
            count[right] -= 1
            count[new_len] += 1

            if count[m] > 0:
                res = step + 1

        return res