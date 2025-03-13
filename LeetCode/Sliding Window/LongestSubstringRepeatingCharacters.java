// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

// Optimal
// T: O(n)           S: O(n)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0, maxLen = 0;
        
        while (right < s.length()){
            if (map.containsKey(s.charAt(right)))
                left = Math.max(map.get(s.charAt(right))+1, left);
            
            map.put(s.charAt(right), right);
            maxLen = Math.max(maxLen, right-left+1);
            right++;
        }
        return maxLen;
    }
}

// T: O(n^2) , Avg: O(n)            S: O(n)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, right = 0, maxLen = 0;
        
        while (right < s.length()){
            while (set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLen = Math.max(maxLen, right-left+1);
            right++;
        }
        return maxLen;
    }
}
