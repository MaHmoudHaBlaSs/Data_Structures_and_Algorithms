///        https://leetcode.com/problems/bag-of-tokens/

//1-sort 
//2-face-up from the min side as possible, and face-down from right when needed

class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens); 
        int score = 0, left = 0, right = tokens.length - 1, ans = 0;
        
        while(left <= right){
            while(left <= right && power >= tokens[left]){
                ans = ++score;
                power -= tokens[left++]; 
            }

            if(left < right && score > 0){
                power += tokens[right--];
                score--;
            } 
            else break; 
        }

        return ans; 
    }
}