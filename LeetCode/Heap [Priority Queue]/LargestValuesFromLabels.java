///  https://leetcode.com/problems/largest-values-from-labels/description/


class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> values[b]-values[a]);
        int max = -1, ans = 0;

        for(int i=0; i<labels.length; ++i){
            if(values[i] > max) max = values[i];
            pq.offer(i);
        }

        int[] freq = new int[max+1];

        for(int i=0; i<numWanted && !pq.isEmpty(); ++i){
            int idx = pq.poll();

            if(freq[labels[idx]] == useLimit){ 
                i--;
                continue;
            }

            freq[labels[idx]]++;
            ans += values[idx];
        }

        return ans;
    }
}