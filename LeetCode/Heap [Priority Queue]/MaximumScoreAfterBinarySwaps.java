///  https://leetcode.com/problems/maximum-score-after-binary-swaps/description/

class Solution {
    public long maximumScore(int[] nums, String s) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        long score = 0; 

        for(int i=0; i<nums.length; ++i){
            pq.offer(nums[i]);

            if(s.charAt(i) == '1'){
                score += pq.poll(); 
            }
        }

        return score; 
    }
}