// https://leetcode.com/problems/sort-vowels-by-frequency/description/


class Solution {
    public String sortVowels(String s) {
        char[] chars = s.toCharArray();
        
       
        Map<Character, Integer> freqMap = new HashMap<>();
        Map<Character, Integer> firstOccurrence = new HashMap<>();
        
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (isVowel(c)) {
                freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
                firstOccurrence.putIfAbsent(c, i);
            }
        }
        
        
        List<Character> vowels = new ArrayList<>(freqMap.keySet());
        vowels.sort((a, b) -> {
            int freqCompare = Integer.compare(freqMap.get(b), freqMap.get(a));
            if (freqCompare != 0) return freqCompare;
            return Integer.compare(firstOccurrence.get(a), firstOccurrence.get(b));
        });
        
        
        List<Character> sortedVowels = new ArrayList<>();
        for (char vowel : vowels) {
            for (int i = 0; i < freqMap.get(vowel); i++) {
                sortedVowels.add(vowel);
            }
        }
        
        
        int vowelIndex = 0;
        StringBuilder result = new StringBuilder();
        for (char c : chars) {
            if (isVowel(c)) {
                result.append(sortedVowels.get(vowelIndex++));
            } else {
                result.append(c);
            }
        }
        
        return result.toString();
    }
    public boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}