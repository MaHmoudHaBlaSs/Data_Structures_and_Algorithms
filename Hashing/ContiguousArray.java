// https://leetcode.com/problems/contiguous-array/

class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>(); map.put(0, -1);
        int sum = 0, maxLen = 0, diff = 0;
        
        for (int i = 0; i < nums.length; i++){
            sum += (nums[i]==0)?-1:1;
            
            if (map.containsKey(sum)){
                diff = i-map.get(sum);
                if (diff > maxLen)
                    maxLen = diff; 
            }else 
                map.put(sum, i);
        }
        return maxLen;
    }
}
