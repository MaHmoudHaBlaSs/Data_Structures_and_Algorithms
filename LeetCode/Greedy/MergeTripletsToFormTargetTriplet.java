///  https://leetcode.com/problems/merge-triplets-to-form-target-triplet/description/


class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean[] taken = new boolean[3];

        for(int[] triplet : triplets){
            if(triplet[0] == target[0] && triplet[1] <= target[1] && triplet[2] <= target[2])
                taken[0] = true;
            if(triplet[1] == target[1] && triplet[0] <= target[0] && triplet[2] <= target[2])
                taken[1] = true;
            if(triplet[2] == target[2] && triplet[0] <= target[0] && triplet[1] <= target[1])
                taken[2] = true;               
        }

        return taken[0] && taken[1] && taken[2];
    }
}