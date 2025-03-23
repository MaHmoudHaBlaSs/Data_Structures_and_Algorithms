// https://leetcode.com/problems/next-greater-element-i/


// Optimal.
// T: O(n)           S: O(n)
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>(); // O(n)
        Map<Integer, Integer> map = new HashMap<>(); // O(n)

        // ~~ O(n)
        for (int ind = 0; ind < nums2.length; ind++){
            while (!stack.isEmpty() && nums2[stack.peek()] < nums2[ind]){
                int poppedInd = stack.pop();
                map.put(nums2[poppedInd], nums2[ind]);
            }
            stack.push(ind);
        }
        // O(m)
        for (int i = 0; i < nums1.length; i++)
            nums1[i] = map.getOrDefault(nums1[i], -1);
        
        return nums1;
    }
}