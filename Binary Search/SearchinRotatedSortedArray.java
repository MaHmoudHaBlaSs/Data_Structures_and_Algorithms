class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length-1;

        while (left <= right){
            int midInd = (left+right)/2;

            if (nums[midInd] == target)
                return midInd;
            // Compairing Values !!
            if (nums[left] <= nums[midInd]){ // mid belongs to left portion
                // Does our target lays in left portion?
                if (target < nums[midInd] && target >= nums[left])
                    right = midInd-1;
                else 
                    left = midInd+1;
            } else { // mid belongs to right portion
                // Does our target lays in right portion?
                if (target <= nums[right] && target > nums[midInd])
                    left = midInd+1;
                else
                    right = midInd-1;
            }
        }
        return -1;
    }
}
