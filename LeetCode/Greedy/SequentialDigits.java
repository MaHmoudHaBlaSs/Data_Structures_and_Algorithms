// https://leetcode.com/problems/sequential-digits/description/

class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();
        String digits = "123456789";
        
        int highDigitsCount = String.valueOf(high).length();
        int lowDigitsCount = String.valueOf(low).length();
        
        for (int length = lowDigitsCount; length <= highDigitsCount; length++) {
            for (int start = 0; start <= 9 - length; start++) {
                int num = Integer.parseInt(digits.substring(start, start + length));
                if (num >= low && num <= high) {
                    result.add(num);
                }
            }
        }

        return result;
    }
}