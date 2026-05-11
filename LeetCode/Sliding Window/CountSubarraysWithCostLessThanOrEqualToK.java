///  https://leetcode.com/problems/count-subarrays-with-cost-less-than-or-equal-to-k/description/


class Solution {
    public long countSubarrays(int[] nums, long k) {
        ArrayDeque<Integer> minDeque = new ArrayDeque<>(), maxDeque = new ArrayDeque<>();

        long ans = 0;
        int left = 0;

        for(int right = 0; right <nums.length; right++){
            //update the max & min
            while (!minDeque.isEmpty() && nums[minDeque.peekLast()] >= nums[right]) minDeque.pollLast();
            while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] <= nums[right]) maxDeque.pollLast();
            
            minDeque.offerLast(right);
            maxDeque.offerLast(right);

            //keep the window valid
            while(left < right && (long)(nums[maxDeque.peekFirst()]-nums[minDeque.peekFirst()]) * (right-left+1) > k){
                left++;
                if(minDeque.peekFirst() < left) minDeque.pollFirst();
                if(maxDeque.peekFirst() < left) maxDeque.pollFirst();
            }
            
            ans += right-left+1;
        }

        return ans;         
    }
}