// https://leetcode.com/problems/concatenation-of-array/description/?envType=problem-list-v2&envId=array

class Solution {
    public int[] getConcatenation(int[] nums) {
		int [] res = new int [2* nums.length];
		int j = 0;
		for(int i = 0 ; i < nums.length ;i++) {
			res[j] = nums[i];
			res[j+nums.length] = nums[i];
			j++;
		}

		return res;
	}
}