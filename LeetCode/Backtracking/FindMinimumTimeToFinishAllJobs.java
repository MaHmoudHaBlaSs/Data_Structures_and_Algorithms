///  https://leetcode.com/problems/find-minimum-time-to-finish-all-jobs/description/

class Solution {
    private int ans = Integer.MAX_VALUE;
    
    private void backtrack(int[] jobs, int[] workerTime, int jobIdx){
        if(jobIdx == jobs.length){
            int max = 0;
            for(int time : workerTime)
                if(time > max) max = time;

            ans = Math.min(ans, max);
            return;
        }

        int currJob = jobs[jobIdx];
        HashSet<Integer> assignedWorkerTimes = new HashSet<>(); 
        for(int j=0; j<workerTime.length; ++j){
            if(workerTime[j] >= ans || assignedWorkerTimes.contains(workerTime[j])) continue;
        
            workerTime[j] += currJob;
            backtrack(jobs, workerTime, jobIdx+1);
            workerTime[j] -= currJob;
            assignedWorkerTimes.add(workerTime[j]);
        }
    }


    public int minimumTimeRequired(int[] jobs, int k) {
        backtrack(jobs, new int[k], 0);
        return ans; 
    }
}