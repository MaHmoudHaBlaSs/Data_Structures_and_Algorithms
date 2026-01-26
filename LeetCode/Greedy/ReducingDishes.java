///  https://leetcode.com/problems/reducing-dishes/description/

class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        int ans = 0, sum=0;
        Arrays.sort(satisfaction);

        int idx = satisfaction.length-1;
        while(idx >= 0){
            int next = ans + satisfaction[idx] + sum;

            if(next < ans) break;

            ans = next;
            sum += satisfaction[idx--]; 
        }

        return ans;
    }
}