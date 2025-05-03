///    https://leetcode.com/problems/numbers-with-same-consecutive-differences/description/

// Use int instead of string for constant time optimization

//T: O(2^N)   
class Solution {
    private ArrayList<Integer> list = new ArrayList<>();
    private int n,k ;

    private void solve(String str){
        if(str.length() == n) {
            list.add(Integer.parseInt(str));
            return;
        }

        char last = str.charAt(str.length()-1);
        if(last - k >= '0')
            solve(str + (char)(last - k));

        if(last + k <= '9' && k != 0)
            solve(str + (char)(last + k));
    }

    public int[] numsSameConsecDiff(int n, int k) {
        this.n = n; this.k = k;

        for(char c = '1'; c <= '9'; c++) 
            solve(String.valueOf(c));
    
        int[] ans = new int[list.size()];
        for(int i=0;i<ans.length; i++)
            ans[i] = list.get(i);
        
        return ans;
    }
}