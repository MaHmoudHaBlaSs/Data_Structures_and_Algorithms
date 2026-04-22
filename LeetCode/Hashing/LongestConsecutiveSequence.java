// https://leetcode.com/problems/longest-consecutive-sequence/description/

// T: O(n)               S: O(n)
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int maxSize = 0;

        for (int num: nums)
            set.add(num);

        // O(n)
        for (int num: nums){
            int size = 1;

            if (set.contains(num-1) || set.contains(num+1)){
                int tempNum = num;
                // At worst case this while will acces all elements N [as summation of all acess times not at each loap]
                while (set.contains(++tempNum)){ 
                    set.remove(tempNum);
                    size++;
                }
                
                tempNum = num;
                while (set.contains(--tempNum)){
                    set.remove(tempNum);
                    size++;
                }
            }

            maxSize = Math.max(maxSize, size);
        }
        return maxSize;
    }
}

// Union-Find solution (less efficient) in python
/*
class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        sequences = {}
        longest = 0
        
        def get_parent(num):
            if num not in sequences:
                return None

            while not isinstance(sequences[num], str):
                num = sequences[num]
            
            return num

        for num in nums:
            if num in sequences: 
                continue

            prv = get_parent(num - 1)
            nxt = get_parent(num + 1)
            
            prv_val = int(sequences.get(prv, 0))
            nxt_val = int(sequences.get(nxt, 0))

            if prv is None and nxt is None:
                sequences[num] = '1'

            elif prv_val >= nxt_val:
                sequences[prv] = str( prv_val + 1 + nxt_val )
                sequences[num] = prv
                if nxt is not None:
                    sequences[nxt] = prv

            else:
                sequences[nxt] = str( nxt_val + 1 + prv_val )
                sequences[num] = nxt
                if prv is not None:
                    sequences[prv] = nxt

            longest = max( longest, prv_val + 1 + nxt_val )

        return longest
*/