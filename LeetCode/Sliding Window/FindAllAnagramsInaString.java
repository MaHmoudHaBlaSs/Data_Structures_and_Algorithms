/// https://leetcode.com/problems/find-all-anagrams-in-a-string/description/

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>(); 
        int pLen = p.length(), sLen = s.length(), left = 0;
        int[] pFreq = new int[26], sFreq = new int[26];
        
        for(int i=0; i<pLen; i++) ++pFreq[p.charAt(i)- 'a'];

        for(int right = 0; right < sLen; right++){
            ++sFreq[s.charAt(right)- 'a'];

            if(right - left + 1 > pLen) 
                --sFreq[s.charAt(left++) - 'a'];

            if(Arrays.equals(sFreq, pFreq)) 
                list.add(left);
        }

        return list;

    }
}