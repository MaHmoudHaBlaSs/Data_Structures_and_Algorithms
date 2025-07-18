///  https://leetcode.com/problems/minimum-difference-in-sums-after-removal-of-elements/description/

class Solution {
    public long minimumDifference(int[] nums) {
        int len = nums.length, n = len/3;
        long[] min = new long[len+1], max = new long[len+1];
        PriorityQueue<Long> left = new PriorityQueue<>((a, b) -> (int)(b-a));
        PriorityQueue<Long> right = new PriorityQueue<>();

        long leftSum = 0, rightSum = 0;
        for (int i = 0; i < len; i++) {
            long l = nums[i], r = nums[len-i-1];

            if(left.size() >= n){
                if(l < left.peek()) {
                    leftSum -= left.poll();
                    leftSum += l;
                    left.add(l);
                }
            }
            else {
                leftSum += l;
                left.add(l);
            }
            min[i+1] = leftSum;


            if(right.size() >= n){
                if(r > right.peek()) {
                    rightSum -= right.poll();
                    rightSum += r;
                    right.add(r);
                }
            }
            else {
                rightSum += r;
                right.add(r);
            }
            max[len-i-1] = rightSum;
        }

        long ans = Long.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            ans = Math.min(ans, min[n+i] - max[n+i]);
        }
        return ans;
    }
}