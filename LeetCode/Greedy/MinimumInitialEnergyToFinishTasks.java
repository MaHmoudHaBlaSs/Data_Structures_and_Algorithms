///  https://leetcode.com/problems/minimum-initial-energy-to-finish-tasks/description/


// The greedy startegy is to start the task that will leave you with the max paossible energy.
// Having maximum diff in energy left at first will lead to requiring less energy in the next tasks,
// by contradiction, if we leave max energy diffs at the end you will finish the tasks with max diffs not used...

class Solution {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (a,b) -> Integer.compare(b[1] - b[0], a[1]- a[0]));
        
        int needed = 0, currEnergy = 0;
        
        for(int[] task : tasks){
            // Do we need energy?
            if(currEnergy < task[1]) {
                needed += task[1] - currEnergy;
                currEnergy = task[1]; 
            }

            currEnergy -= task[0];
        }
        
        return needed;
    }
}