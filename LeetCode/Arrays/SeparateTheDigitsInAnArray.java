// https://leetcode.com/problems/separate-the-digits-in-an-array/description/

class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> resultList = new ArrayList<>();
        for (int num : nums) {
            String numStr = Integer.toString(num);
            for (char digitChar : numStr.toCharArray()) {
                resultList.add(digitChar - '0'); // Convert char to int
            }
        }
        return resultList.stream().mapToInt(i -> i).toArray();
    }
}