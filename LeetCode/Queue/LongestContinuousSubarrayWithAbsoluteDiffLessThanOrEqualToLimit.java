///  https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/description/


class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int ans = 1, start = 0;
        Deque<Integer> inc =  new ArrayDeque<>(), dec = new ArrayDeque<>();
        
        for(int i=0; i<nums.length; i++){
            int num = nums[i];
            
            while(!inc.isEmpty() && nums[inc.peekLast()] > num) inc.pollLast();
            inc.addLast(i); 
                       
            while(!dec.isEmpty() && nums[dec.peekLast()] < num) dec.pollLast();
            dec.addLast(i);

            while(start < i && nums[dec.peekFirst()] - nums[inc.peekFirst()] > limit){
                ++start;

                while(inc.peek() < start) inc.poll();
                while(dec.peek() < start) dec.poll();
            }

            ans = Math.max(ans, i - start+1);
        }

        return ans;
    }
}