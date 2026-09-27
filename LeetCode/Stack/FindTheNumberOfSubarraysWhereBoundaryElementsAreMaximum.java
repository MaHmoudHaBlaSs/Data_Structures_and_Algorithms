///  https://leetcode.com/problems/find-the-number-of-subarrays-where-boundary-elements-are-maximum/description/

class Solution {
    public long numberOfSubarrays(int[] nums) {
        ArrayDeque<int[]> stack = new ArrayDeque<>();
        
        long ans = 0;

        for (int num : nums) {
            while (!stack.isEmpty() && stack.peek()[0] < num) {
                stack.pop();
            }

            if (!stack.isEmpty() && stack.peek()[0] == num) {
                ans += stack.peek()[1] + 1;
                stack.peek()[1]++;
            } else {
                ans++;

                stack.push(new int[]{num, 1});
            }
        }

        return ans;
    }
}