// https://leetcode.com/problems/strictly-palindromic-number/description/

class Solution {
    public boolean isStrictlyPalindromic(int n) {
		for(int i = 2 ; i <= n-2 ; i++){
			if(! checkPalindromic(n,i))return false;
		}
		return true;
	}
	public boolean checkPalindromic (int n , int base){
		StringBuilder sb = new StringBuilder();
		int reminder ;
		while(n >= 1){
			reminder = n % base ;
			n/=base;
			sb.append(reminder);
		}
		sb.reverse();
		char [] word = sb.toString().toCharArray(); 
		int left = 0 , right = word.length-1;
		while (left < right) {
			if (word[left] != word[right]) {
				return false;
			}
			left++;
			right--;
		}

		return true;
		
	}
}