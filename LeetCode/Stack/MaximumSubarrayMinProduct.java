///  https://leetcode.com/problems/maximum-subarray-min-product/description/

class Solution {
    private static final long MOD = 1_000_000_007;

    public int maxSumMinProduct(int[] nums) {
        int n = nums.length;
        long[] prefix = new long[n+1];
        int[] nextSmaller = new int[n], prevSmaller = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; ++i) {
            prefix[i+1] = prefix[i] + nums[i];

            while(!st.isEmpty() && nums[i] <= nums[st.peek()])
                st.pop();

            prevSmaller[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        st.clear();

        for (int i=n-1; i>=0; --i){
            while(!st.isEmpty() && nums[i] <= nums[st.peek()])
                st.pop();

            nextSmaller[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        long ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, nums[i] * (prefix[nextSmaller[i]] - prefix[prevSmaller[i]+1]));
        }
        
        return (int) (ans % MOD);
    }
}