/// https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/description/


class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] leftToRight = new int[n], rightToLeft = new int[n];
        int leftCount = boxes.charAt(0) - '0', rightCount =  boxes.charAt(n-1) - '0';

        for(int i=1; i<n; i++){
            leftToRight[i] = leftToRight[i-1] + leftCount;
            if(boxes.charAt(i) == '1') leftCount++;

            rightToLeft[n-i-1] = rightToLeft[n-i] + rightCount;
            if(boxes.charAt(n-i-1) == '1') rightCount++;
        }   

        for(int i=0; i<n; i++) rightToLeft[i] += leftToRight[i];

        return rightToLeft;
    }
}