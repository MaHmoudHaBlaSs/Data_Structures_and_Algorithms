/// https://leetcode.com/problems/split-array-with-same-average/description/

class Solution {
    private int[] nums;
    private Map<String, Boolean> memo;
    
    public boolean splitArraySameAverage(int[] nums) {
        int n = nums.length, total = 0;

        for (int x : nums) {
            total += x;
        }

        this.nums = nums;
        for (int k = 1; k <= n / 2; k++) {
            if ((total * k) % n != 0) {
                continue;
            }

            int target = total * k / n;

            memo = new HashMap<>();

            if (solve(0, k, target)) return true;
        }

        return false;
    }

    private boolean solve(int i, int k, int target) {
        if (k == 0) {
            return target == 0;
        }

        if (i == nums.length || target < 0) {
            return false;
        }

        String key = i + "," + k + "," + target;

        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        boolean result = solve(i + 1, k - 1, target - nums[i]) || solve(i + 1, k, target);

        memo.put(key, result);

        return result;
    }
}