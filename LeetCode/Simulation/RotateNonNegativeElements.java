///  https://leetcode.com/problems/rotate-non-negative-elements/description/


class Solution {
    public int[] rotateElements(int[] nums, int k) {
        ArrayList<Integer> nonNeg = new ArrayList<>(); 

        for(int num : nums){
            if(num >= 0) nonNeg.add(num);  
        }

        int n = nonNeg.size(); 
        if(n > 0) k %= n;
        if(k == 0) return nums;
        
        int j = k;

        for(int i=0; i<nums.length; ++i){
            if(nums[i] >= 0){
                nums[i] = nonNeg.get(j);
                j = (j+1) % n;
            }
        } 

        return nums;
    }
}