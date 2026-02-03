//https://leetcode.com/problems/detect-capital/description/


class Solution {
    public boolean detectCapitalUse(String word) {
        String copyWord = word.toUpperCase();
        boolean flag1 = word.equals(copyWord);
        String firstLetter = word.substring(0, 1).toUpperCase();
        String wordWithoutFirstLetter = word.substring(1).toLowerCase();
        boolean flag2 = word.substring(0, 1).equals(firstLetter) && word.substring(1).equals(wordWithoutFirstLetter);
        
        String lowerCaseWord = word.toLowerCase();
        boolean flag3 = word.equals(lowerCaseWord);
        return flag1 || flag2 || flag3;
}
}