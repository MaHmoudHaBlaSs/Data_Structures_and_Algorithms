/// https://leetcode.com/problems/find-servers-that-handled-most-number-of-requests/description/


class Solution {

    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int[] freq = new int[k];
        int max = 0;

        TreeSet<Integer> available = new TreeSet<>();
        PriorityQueue<int[]> busy = new PriorityQueue<>((a,b) -> a[1] - b[1]); // [server, time]

        for (int i = 0; i < k; i++) {
            available.add(i);
        }

        for (int i = 0; i < arrival.length; i++) {
            int j = i%k, currTime = arrival[i];

            while(!busy.isEmpty() && busy.peek()[1] <= currTime){
                available.add(busy.poll()[0]);
            }

            if(available.size() == 0) continue;

            Integer next = available.ceiling(j);
            if(next == null) next = available.pollFirst();

            available.remove(next);
            busy.add(new int[]{next, currTime+load[i]});
            int count = ++freq[next];

            if(count > max) max = count;
        }

        int finalMax = max;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if(freq[i] == max)
                ans.add(i);
        }

        return ans;
    }
}