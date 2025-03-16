// https://leetcode.com/problems/longest-repeating-character-replacement/

// T: O(n)       S: O(n)
class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0, max = 0, maxLen = 0;

        while (right < s.length()){
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0)+1);
            max = Math.max(map.get(s.charAt(right)), max);

            while (right-left+1-max > k){ 
                map.put(s.charAt(left) , map.get(s.charAt(left))-1);
                left++;
            }
            maxLen = Math.max(maxLen, right-left+1);
            right++;
        }
        return maxLen;
    }
}
// Notice: when we increase left pointer notice that we don't mdoify max value which
// may look confusing and missleading but if you brainstorm it you will deduce that 
// we want the maximum length which is the max value of this expression `Length - Max <= k` -> [inner while condition]
// so when we reach a certain max value we will update the maxLen and later on when the window shrinks 
// we won't update max because we already have a previous maxLen value at that max so the next maxLen (if exists) 
// will be on a max value larger than the previous max value that led to the previous maxLen.