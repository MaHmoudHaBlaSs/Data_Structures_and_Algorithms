//https://leetcode.com/problems/sort-the-students-by-their-kth-score/description/?envType=problem-list-v2&envId=sorting

class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {
        Arrays.sort(score , new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o2[k], o1[k]);
            }
        });
        return score;

    }
}