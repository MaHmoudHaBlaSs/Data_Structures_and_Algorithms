// https://leetcode.com/problems/guess-number-higher-or-lower/description/?envType=study-plan-v2&envId=leetcode-75


/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int left = 1 , right = n , mid = -1; 
         

        while (left <= right) {
            mid = left + (right - left) / 2; 

            int result = guess(mid); 

            if (result == 0) {
                return mid; 
            } else if (result == -1) {
                right = mid - 1; 
            } else {
                left = mid + 1; 
            }
        }

        return mid; 
    }
}