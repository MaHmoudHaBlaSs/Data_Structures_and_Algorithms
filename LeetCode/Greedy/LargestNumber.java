///     https://leetcode.com/problems/largest-number/description/

/*
1-Sort the numbers in increasing order, based on concatenation order.
2-Repeatedly take the largest number.
*/

class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        StringBuilder ans = new StringBuilder();
        String[] arr = new String[n];

        for(int i=0; i<n; i++)
            arr[i] = Integer.toString(nums[i]);

        Arrays.sort(arr, (n1,n2) -> (n1 + n2).compareTo(n2 + n1));
  
        if (arr[n-1].equals("0"))
            return "0";

        for(int i=n-1; i>= 0; i--)
            ans.append(arr[i]); 
        
        return ans.toString();
    }
}