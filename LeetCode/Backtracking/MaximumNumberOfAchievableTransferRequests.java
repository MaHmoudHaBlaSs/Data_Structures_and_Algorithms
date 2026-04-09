///  https://leetcode.com/problems/maximum-number-of-achievable-transfer-requests/editorial/

class Solution {
    private final int oo = 0x3f3f3f3f;

    public int maximumRequests(int n, int[][] requests) {
        return countRequests(0, requests, new int[n]);
    }

    private int countRequests(int i, int[][] requests, int[] freq){
        if(i == requests.length){
            for(int f : freq){
                if(f != 0) return -oo; 
            }
            return 0;
        }

        int from = requests[i][0], to = requests[i][1];

        int op1 = countRequests(i+1, requests, freq); //  skip requests[i]
        
        freq[from]++;
        freq[to]--;
        int op2 = 1+countRequests(i+1 ,requests, freq); // achieve requests[i]
        freq[from]--;
        freq[to]++;        

        return Math.max(op1, op2);
    }
}
