///   https://leetcode.com/problems/count-number-of-teams/description/

class Solution {
    public int numTeams(int[] rating) {
        int ans = 0, n=rating.length;

        for(int j=0; j<n; ++j){
            int leftSmaller = 0, leftGreater = 0;
            int rightSmaller = 0, rightGreater = 0;

            for (int i = 0; i < j; i++) {
                if (rating[i] < rating[j]) leftSmaller++;
                else if (rating[i] > rating[j]) leftGreater++;
            }

            for (int k = j + 1; k < n; k++) {
                if (rating[k] < rating[j]) rightSmaller++;
                else if (rating[k] > rating[j]) rightGreater++;
            }

            ans += leftSmaller * rightGreater; 
            ans += rightSmaller * leftGreater; 
        }
        
        return ans;
    }
}