/// https://leetcode.com/problems/sort-integers-by-the-power-value/description/

class Solution {
    private HashMap<Integer,Integer> memo = new HashMap<>();
    private int power(int x){
        if(x == 1) return 0;

        if(memo.containsKey(x)) return memo.get(x);

        int next = (x&1) == 0 ? (x>>1) : 3*x + 1;
        int ans = 1+power(next);
        memo.put(x,ans);

        return ans;  
    }

    public int getKth(int lo, int hi, int k) {
        memo.put(2,1);
        int[][] arr = new int[hi-lo+1][2];

        for(int i=lo; i<=hi; ++i){ 
            arr[i-lo][0]=i;
            arr[i-lo][1]=power(i);
        }

        Arrays.sort(arr, (a,b) -> {
            if(a[1] == b[1]) return a[0]-b[0];
            
            return a[1]-b[1];
        });

        return arr[k-1][0];
    }
}