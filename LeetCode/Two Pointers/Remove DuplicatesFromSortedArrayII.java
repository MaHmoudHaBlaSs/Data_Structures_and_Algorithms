// https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/

class Solution {
    public int removeDuplicates(int[] nums) {
        int main = 1, swapper = 0, streak = 1, temp;

        while (main < nums.length && swapper < nums.length){
            if (nums[main-1] > nums[main]){ 
                // Swapped Needed for encountring previous swapped value. 
                temp = nums[main];
                nums[main] = nums[swapper];
                nums[swapper] = temp;
                swapper++;
            }

            streak = (nums[main] == nums[main-1])?streak+1:1;            
            if (streak == 3){ 
                // Swap Needed for streak limit.
                while (swapper < nums.length && nums[swapper] <= nums[main])
                    swapper++;
                if (swapper >= nums.length)
                    break;
                temp = nums[main];
                nums[main] = nums[swapper];
                nums[swapper] = temp;
                streak = 1;
                swapper++;
            }
            main++;
        }
        return main;
    }
}
