//https://leetcode.com/problems/decode-string/description/


public class Solution {
    public string DecodeString(string s)
    {
        Stack<char> stack = new Stack<char>();
        StringBuilder result = new StringBuilder();

        foreach (char c in s)
        {
            if (c == ']')
            {
                string sb = string.Empty;
                
                while (stack.Peek() != '[')
                {
                    sb = stack.Pop() + sb;
                }

                stack.Pop(); 


                string number = string.Empty;
                while (stack.Count > 0 && char.IsDigit(stack.Peek()))
                {
                    number = stack.Pop() + number;
                }

                int repeatCount = int.Parse(number);

                
                string repeated = string.Empty;
                for (int i = 0; i < repeatCount; i++)
                {
                    foreach (char ch in sb)
                    {
                        stack.Push(ch);
                    }
                }
            }
            else
            {
                stack.Push(c);
            }
        }

        
        StringBuilder final = new StringBuilder();
        while (stack.Count > 0)
        {
            final.Insert(0, stack.Pop());
        }

        return final.ToString();
    }
}