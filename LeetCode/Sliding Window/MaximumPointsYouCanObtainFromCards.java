///  https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/description/


class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum=0, min=0, n = cardPoints.length, m=n-k, curr = 0;

        for(int i=0; i<n; ++i){
            sum += cardPoints[i];

            if(i<m){ 
                min = sum;
                curr = sum;    
            }
            else{
                curr += cardPoints[i] - cardPoints[i-m];
                min = Math.min(min, curr);
            }
        }

        return sum - min;
    }
}