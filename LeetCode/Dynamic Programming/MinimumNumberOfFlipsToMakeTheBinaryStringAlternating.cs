///  https://leetcode.com/problems/minimum-number-of-flips-to-make-the-binary-string-alternating/description/


public class Solution {
    public int MinFlips(string s)
    {
        (int zero, int one) evens = (0, 0);
        (int zero, int one) odds = (0, 0);

        for (int i = 0; i < s.Length; i++)
        {
            if ((i & 1) == 0)
            {
                if (s[i] == '0') evens.zero++;
                else evens.one++;    
            }
            else
            {
                if (s[i] == '0') odds.zero++;
                else odds.one++;
            }
        }

        int ans = Math.Min(evens.zero + odds.one, evens.one + odds.zero);
        if ((s.Length & 1) == 0) return ans;

        (int zero, int one) prevEvens = (0, 0);
        (int zero, int one) prevOdds = (0, 0);
        for (int i = 0; i < s.Length; i++)
        {
            (int zero, int one) currEvens = (evens.zero - prevEvens.zero + prevOdds.zero, evens.one - prevEvens.one + prevOdds.one);
            (int zero, int one) currOdds = (odds.zero - prevOdds.zero + prevEvens.zero, odds.one - prevOdds.one + prevEvens.one);

            ans = Math.Min(ans, Math.Min(currEvens.zero + currOdds.one, currEvens.one + currOdds.zero));
            
            if ((i & 1) == 0)
            {
                if (s[i] == '0') prevEvens.zero++;
                else prevEvens.one++;
            }
            else
            {
                if (s[i] == '0') prevOdds.zero++;
                else prevOdds.one++;
            }
        }
        
        return ans;
    }
}