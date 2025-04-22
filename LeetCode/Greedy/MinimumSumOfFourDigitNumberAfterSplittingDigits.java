// https://leetcode.com/problems/minimum-sum-of-four-digit-number-after-splitting-digits/description/?envType=problem-list-v2&envId=greedy


class Solution {
    public int minimumSum(int num) {
        String s = String.valueOf(num);
        int sum = 0;
        int [] arr = new int [s.length()]; 
        for(int i = 0; i < s.length(); i++){
            arr[i] = Integer.parseInt(String.valueOf(s.charAt(i)));
        }
        Arrays.sort(arr);

        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();
        num1.append(arr[0]);
        num1.append(arr[2]);
        num2.append(arr[1]);
        num2.append(arr[3]);
        return Integer.parseInt(num1.toString()) + Integer.parseInt(num2.toString());
    }
}
