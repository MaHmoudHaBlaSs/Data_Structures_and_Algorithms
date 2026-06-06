///  https://leetcode.com/problems/smallest-all-ones-multiple/description/

class Solution {
    public int minAllOneMultiple(int k) {
        HashSet<Integer> set = new HashSet<>();
        int n = 1, i=1;

        while(n != 0 && !set.contains(n)){
            set.add(n);
            n *= 10;
            n += 1;
            n %= k;            
            i++;
        }

        return n==0? i : -1;
    }
}