## https://leetcode.com/problems/find-the-distance-value-between-two-arrays
# return the number of elements in arr1 for which there is no element in arr2 with an 
# absolute difference smaller than or equal to d.

# Time: O(nlog(n))
class Solution:
    def findTheDistanceValue(self, arr1: List[int], arr2: List[int], d: int) -> int:
        arr2.sort()
        violating_nums = 0

        for num in arr1:
            l, r = 0, len(arr2)-1        
            
            while l <= r:
                m = (l + r) // 2
                diff = abs(num - arr2[m])

                if diff <= d:
                    violating_nums += 1
                    break
                else: # diff > d
                    if num > arr2[m]:
                        l = m + 1
                    else:
                        r = m - 1 

        return len(arr1) - violating_nums