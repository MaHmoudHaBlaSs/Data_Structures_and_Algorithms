// https://leetcode.com/problems/find-the-duplicate-number/description/

// Before solving this problem firstly, you need to solve LinkedListCycleII problem. 

// Optimal Solution
// T: O(n)          S: O(1)
class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;

        while(true){
            fast = nums[nums[fast]];
            slow = nums[slow];
            if (slow == fast){
                slow = 0;
                while (slow != fast){
                    fast = nums[fast];
                    slow = nums[slow];
                }
                return fast;
            }
        }
    }
}