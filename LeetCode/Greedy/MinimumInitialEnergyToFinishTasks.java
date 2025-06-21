///  https://leetcode.com/problems/minimum-initial-energy-to-finish-tasks/description/


//The greedy startegy is to start the task that will leave you with the max paossible energy.

class Solution {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (a,b) -> Integer.compare(b[1] - b[0], a[1]- a[0]));
        
        int needed = 0, currEnergy = 0;
        
        for(int[] task : tasks){
            if(currEnergy < task[1]) {
                needed += task[1] - currEnergy;
                currEnergy = task[1]; 
            }

            currEnergy -= task[0];
        }
        
        return needed;
    }
}