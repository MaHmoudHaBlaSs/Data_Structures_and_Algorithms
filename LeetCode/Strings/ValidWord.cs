// https://leetcode.com/problems/valid-word/


public class Solution {
    public bool IsValid(string word)
    {
        if (word.Length < 3)
            return false;

        bool hasVowel = false;
        bool hasConsonant = false;

        foreach (char c in word)
        {
            if (!char.IsLetterOrDigit(c))
                return false; 

            if (char.IsLetter(c))
            {
                char lower = char.ToLower(c);
                if ("aeiou".Contains(lower))
                    hasVowel = true;
                else
                    hasConsonant = true;
            }
        }

        return hasVowel && hasConsonant;
    }

}