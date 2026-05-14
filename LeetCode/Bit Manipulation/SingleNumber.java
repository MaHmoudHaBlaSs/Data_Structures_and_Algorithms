// https://leetcode.com/problems/single-number/description/


class Solution {
    /*
    public int singleNumber(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num)) {
                seen.remove(num);
            } else {
                seen.add(num);
            }
        }
        return seen.iterator().next();
    }
    */

    // we use xor -> ( y ^ y = 0 )
    public int singleNumber(int[] nums) {
        int res = 0 ;
        for (int num : nums) {
            res^=num;
        }
        return res;
    }
}