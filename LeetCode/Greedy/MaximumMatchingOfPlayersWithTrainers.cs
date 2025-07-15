// https://leetcode.com/problems/maximum-matching-of-players-with-trainers/description/


public class Solution {
    public int MatchPlayersAndTrainers(int[] players, int[] trainers)
    {
        int result = 0;
        Array.Sort(players);
        Array.Sort(trainers);
        int playerIndex = players.Length - 1 ;
        int trainerIndex = trainers.Length - 1;
        while (playerIndex >= 0 && trainerIndex >= 0)
        {
            if (players[playerIndex] <= trainers[trainerIndex])
            {
                result++;
                trainerIndex--;
            }
            playerIndex--;
        }
        return result;
    }
}