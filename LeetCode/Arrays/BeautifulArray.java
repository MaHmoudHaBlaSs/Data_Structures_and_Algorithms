// https://leetcode.com/problems/beautiful-array/description/

// This problem is an divide and conquer problem 
// we divide the the array to odd and even numbers 
// starting from base n = 1 
// taking the sutible sol for 1 -> 2 -> 3 -> as we go 
// even = 2 * x  , odd = 2 * x - 1

class Solution {
    public int[] beautifulArray(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(1);   // base case

        while (result.size() < n) {
            List<Integer> next = new ArrayList<>();

            // generate odd numbers
            for (int x : result) {
                int odd = 2 * x - 1;
                if (odd <= n) {
                    next.add(odd);
                }
            }

            // generate even numbers
            for (int x : result) {
                int even = 2 * x;
                if (even <= n) {
                    next.add(even);
                }
            }

            result = next;
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }

}