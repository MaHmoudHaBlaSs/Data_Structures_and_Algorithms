///  https://leetcode.com/problems/form-largest-integer-with-digits-that-add-up-to-target/description/

class Solution {
    private String[] memo;

    private String solve(int[] cost, int target){
        if(target == 0) return "";

        if(memo[target] != null) return memo[target];

        String ans = "0";

        for(int i=8; i>=0; --i){
            if(cost[i] != -1 && cost[i] <= target){
                String op = solve(cost, target-cost[i]);
                if(!op.equals("0"))
                    ans = max(ans, (i+1) + op);
            }
        }

        return memo[target]=ans;
    }

    private String max(String str1, String str2){
        if(str1.equals("0") || str1.length()<str2.length()) return str2;

        if(str2.length() < str1.length()) return str1;

        int n=str1.length();
        for(int i=0;i<n; ++i){
            char c1 = str1.charAt(i), c2 = str2.charAt(i);
            if(c1 > c2) return str1;
            if(c2 > c1) return str2;
        }

        return str1;
    }

    public String largestNumber(int[] cost, int target) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=8;i>=0;--i){
            if(!set.add(cost[i])){
                cost[i] = -1;
            }
        }

        memo = new String[target+1];
        return solve(cost,target);
    }
}