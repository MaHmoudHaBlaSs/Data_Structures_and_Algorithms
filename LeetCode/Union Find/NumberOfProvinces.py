# https://leetcode.com/problems/number-of-provinces

# T: O(n*n)       S: O(n)
class Solution:
    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        def get_parent(list, i) -> int:            
            while list[i] >= 0:
                i = list[i]
            return i


        union = [-1 for _ in range(len(isConnected))]
        res = len(isConnected)

        for city in range(len(isConnected)):
            for target in range(city + 1, len(isConnected)):
                if isConnected[city][target]:
                    city_parent = get_parent(union, city)
                    target_parent = get_parent(union, target)
                
                    if city_parent == target_parent: continue

                    if union[city_parent] <= union[target_parent]:
                        union[city_parent] += union[target_parent]
                        union[target_parent] = city_parent
                    else:
                        union[target_parent] += union[city_parent]
                        union[city_parent] = target_parent
                    res -= 1

        return res