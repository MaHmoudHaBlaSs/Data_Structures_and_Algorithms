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