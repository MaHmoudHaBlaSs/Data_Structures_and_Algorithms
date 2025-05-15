// https://leetcode.com/problems/task-scheduler/


// T: O(n)                s: O(n)
class Solution {

    public int leastInterval(char[] tasks, int n) {
        int[] freqs = new int[26];
        for (char ch: tasks) freqs[ch-'A']++;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        Queue<int []> coolingDown = new LinkedList<>();
        
        for(int i = 0; i < freqs.length; i++)
            if(freqs[i] > 0) maxHeap.add(freqs[i]);

        int intervals = 0;

        
        while (!maxHeap.isEmpty() || !coolingDown.isEmpty()){
            intervals++;

            if (!coolingDown.isEmpty() && coolingDown.peek()[1] == intervals){
                int[] cooledTask = coolingDown.poll();
                maxHeap.add(cooledTask[0]); // O(log26) -> O(1)
            }
                
            if (maxHeap.isEmpty())  
                continue;

            int currFreq = maxHeap.poll(); 
            if (currFreq-1 > 0) coolingDown.add(new int[]{currFreq-1, intervals + n+1}); 

        }
        return intervals;
    }
}