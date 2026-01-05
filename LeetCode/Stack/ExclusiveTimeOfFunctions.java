// https://leetcode.com/problems/exclusive-time-of-functions/description/?envType=problem-list-v2&envId=dsa-linear-shoal-stack

// T: O(n)        S: O(n)
class Solution {
    class Entry{
        int start;
        int elapsed;

        public Entry(int start, int elapsed){
            this.start = start;
            this.elapsed = elapsed;
        }
    }
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Entry> callStack = new Stack<>();
        int[] timeExclusive = new int[n];
        Arrays.fill(timeExclusive, 0);

        // Start affects elapsed
        // End affects start
        for (String log: logs){
            String[] status = log.split(":");
            int id = Integer.valueOf(status[0]);
            int time = Integer.valueOf(status[2]);
            
            if (status[1].equals("start")){
                if (!callStack.isEmpty()){
                    Entry entry = callStack.pop();
                    entry.elapsed += time - entry.start;
                    callStack.push(entry);
                }
                callStack.push(new Entry(time, 0));

            }else{
                Entry entry = callStack.pop();

                if (entry.elapsed == 0){ // No Gap
                    timeExclusive[id] += time - entry.start + 1;
                }else{
                    timeExclusive[id] += time - entry.start + 1 + entry.elapsed;
                }

                if (!callStack.isEmpty()){
                    entry = callStack.pop();
                    entry.start = time + 1;
                    callStack.push(entry);
                }
            }
        }
        return timeExclusive;
    }
}
