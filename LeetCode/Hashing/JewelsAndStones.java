// https://leetcode.com/problems/jewels-and-stones/description/?envType=problem-list-v2&envId=hash-table

class Solution {
    public int numJewelsInStones(String jewels, String stones) {
		Set<Character> set = new HashSet<>();
		for(char c : jewels.toCharArray()){
			set.add(c);
		}
		int count = 0;
		for(char x  : stones.toCharArray()){
			if(set.contains(x))
				count++;
		}
		return count;
	}
}