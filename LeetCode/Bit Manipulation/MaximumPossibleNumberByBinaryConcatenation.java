///  https://leetcode.com/problems/maximum-possible-number-by-binary-concatenation/description/

class Solution {
    public int maxGoodNumber(int[] nums) {
        int[][] options = new int[][]{
            {0,1,2}, {0,2,1}, {1,2,0}, {1,0,2}, {2,0,1}, {2,1,0}
        };
        
        int ans = 0;

        for(int[] op : options){
            String bin = "";
            
            for(int i : op){
                bin += Integer.toBinaryString(nums[i]);
            }

            ans = Integer.max(ans, Integer.valueOf(bin, 2));
        }

        return ans;
    }
}