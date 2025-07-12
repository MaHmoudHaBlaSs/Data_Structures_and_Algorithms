// https://leetcode.com/problems/dota2-senate/?envType=study-plan-v2&envId=leetcode-75

public class Solution {
    public string PredictPartyVictory(string senate) {
        int radiantCount = 0;
        int direCount = 0;
        Queue<int> radiantQueue = new Queue<int>();
        Queue<int> direQueue = new Queue<int>();

        for (int i = 0; i < senate.Length; i++) {
            if (senate[i] == 'R') {
                radiantCount++;
                radiantQueue.Enqueue(i);
            } else {
                direCount++;
                direQueue.Enqueue(i);
            }
        }

        while (radiantCount > 0 && direCount > 0) {
            int radiantIndex = radiantQueue.Dequeue();
            int direIndex = direQueue.Dequeue();

            if (radiantIndex < direIndex) {
                direCount--;
                radiantQueue.Enqueue(radiantIndex + senate.Length);
            } else {
                radiantCount--;
                direQueue.Enqueue(direIndex + senate.Length);
            }
        }

        return radiantCount > 0 ? "Radiant" : "Dire";
    }
}
