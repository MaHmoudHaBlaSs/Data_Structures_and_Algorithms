///  https://leetcode.com/problems/count-sequences-to-k/description/


class Solution {
    public int countSequences(int[] nums, long k) {
        HashMap<String, Integer> memo = new HashMap<>(); 
        return solve(0, 1, 1, nums, k, memo);
    }

    private int solve(int i, long num, long den, int[]nums, long k, HashMap<String, Integer> memo){
        long g = gcd(num, den); 
        num /= g; 
        den /= g;
        
        if(i == nums.length){
            if(num % den == 0 && num/den == k) 
                return 1;
            
            return 0;
        }

        String key = i+","+num+","+den;
        if(memo.containsKey(key)) return memo.get(key); 

        int ans = solve(i+1, num, den, nums, k, memo);
        ans += solve(i+1, num*nums[i], den, nums, k, memo);
        ans += solve(i+1, num, den*nums[i], nums, k, memo);

        memo.put(key, ans); 
        return ans; 
    }

    private long gcd(long a, long b){
        while(b != 0){
            long rem = a%b; 
            a = b; 
            b = rem; 
        }

        return a; 
    }
}