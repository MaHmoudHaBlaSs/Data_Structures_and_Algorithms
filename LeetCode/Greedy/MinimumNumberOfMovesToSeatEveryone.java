// https://leetcode.com/problems/minimum-number-of-moves-to-seat-everyone/description/?envType=problem-list-v2&envId=greedy

// O( N*Log(N) )
class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int moves = 0;
        for (int i = 0; i < seats.length; i++) {
            moves += Math.abs(students[i] - seats[i]);
        }
        return moves;
    }
}
