///  https://leetcode.com/problems/maximum-value-after-insertion/description/

public class Solution {
    public string MaxValue(string n, int x) {
        StringBuilder str = new StringBuilder(n);
        int i = 0;
        
        if(n[0] == '-')     
            while(i<n.Length && n[i]-'0' <= x) i++;
        else
            while(i<n.Length && n[i]-'0' >= x) i++;
        

        str.Insert(i,x);
        return str.ToString();
    }
}