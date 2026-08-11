///  https://leetcode.com/problems/maximize-the-minimum-powered-city/description/

class Solution {
    public long maxPower(int[] stations, int r, int k) {
        long left = Long.MAX_VALUE, right = Long.MIN_VALUE;
        long ans = 0;
        
        for(int st : stations){
            if(left > st) left = st;
            if(right < st) right = st;
        }        
        
        right *= (r+1)*2;
        right += k;

        while(left <= right){
            long mid = (left+right) >> 1;

            if(canPower(stations,r,k, mid)){
                ans = mid;
                left = mid + 1;
            }
            else right = mid - 1;
        }
         
        return ans;
    }

    private boolean canPower(int[] stations, int r, long k, long limit){
        int n = stations.length;
        long[] stCopy = new long[n];
        Deque<Integer> deq = new ArrayDeque<>();
        long sum = 0;

        for(int i=0; i<n; ++i){
            while(!deq.isEmpty() && i - deq.peekFirst() > r){
                int rem = deq.removeFirst(); 
                sum -= stations[rem] + stCopy[rem];
            } 

            while(deq.isEmpty() || (deq.peekLast() - i < r && deq.peekLast() < n-1)){
                int added = deq.isEmpty()? i : deq.peekLast() + 1;
                deq.addLast(added);
                sum += stations[added];
            }

            if(sum < limit){
                long diff = limit - sum;

                if(k < diff) return false;

                k -= diff; 
                stCopy[deq.peekLast()] = diff;
                sum += diff;
            }
        }

        return true;
    }
}
