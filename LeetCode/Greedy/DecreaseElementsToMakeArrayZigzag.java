/// https://leetcode.com/problems/decrease-elements-to-make-array-zigzag/description/

class Solution {
    public int movesToMakeZigzag(int[] nums) {
        int count1 = 0, count2 = 0, n =nums.length;
        int[] arr = Arrays.copyOf(nums,n); 

        for(int i=0; i<n; i++){
            if((i & 1) == 0){
                if(i-1 != -1 && nums[i] <= nums[i-1]) count1 += nums[i-1] - nums[i] + 1;
                
                if(i+1 != n && nums[i] <= nums[i+1]){ 
                    count1 += nums[i+1] - nums[i] + 1;
                    nums[i+1] = nums[i] - 1;
                }
            }
            else {
                if(arr[i] <= arr[i-1]) count2 += arr[i-1] - arr[i] + 1;

                if(i+1 != n && arr[i] <= arr[i+1]){ 
                    count2 += arr[i+1] - arr[i] + 1;
                    arr[i+1] = arr[i] - 1;
                }
            }
        }

        return Math.min(count1, count2); 
    }
}