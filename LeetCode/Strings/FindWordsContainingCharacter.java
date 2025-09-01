// https://leetcode.com/problems/find-words-containing-character/description/?envType=problem-list-v2&envId=array


class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
		List<Integer> res = new ArrayList<>();
		for (int i =0 ; i < words.length ; i++){
			if(words[i].contains( String.valueOf(x)))
				res.add(i);
		}

		return res;

	}
}