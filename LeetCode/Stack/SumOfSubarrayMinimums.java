///  https://leetcode.com/problems/sum-of-subarray-minimums/description/

/*
For each number arr[i]: 
    find the nearest element smaller than it on the left ( arr[left] ) 
    find the nearest element smaller than it on the right ( arr[right] ) 
then nums[i] will be the smallest element in all subarrays include nums[i] from left to right

Using increasing monotonic stack: 
    arr[left] is the top of the stack before pushing arr[i]
    arr[right] is the number that will pop arr[i] from the stack
*/

class Solution {
    final int MOD = 1_0000_00007;  

    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long sum = 0;
        Stack<Integer> stack = new Stack<>();
        int[] multiplier = new int[n];
        Arrays.fill(multiplier, 1);


        for(int i=0; i<n; i++){
            while(!stack.isEmpty() && arr[stack.peek()]>arr[i]){
                multiplier[stack.peek()] *= i-stack.peek();
                stack.pop();
            }
            
            multiplier[i] *= stack.isEmpty() ? i+1 : i-stack.peek();
            stack.push(i);
        }

        while(!stack.isEmpty()){
            multiplier[stack.peek()] *= n-stack.peek();
            stack.pop();
        }
        
        for(int i=0; i<n; i++){
            sum = (sum + (long)arr[i]*multiplier[i])%MOD;
        }

        return (int)sum;
    }
}