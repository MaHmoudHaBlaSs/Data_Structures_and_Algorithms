///  https://leetcode.com/problems/russian-doll-envelopes/description/

/*
The straight forward approach is to use dp and like longest increasing subscequence but it take O(n^2).

The optimization for it, takes O(nlog(n)), but to use the optmized approch with this problem:
    sort the envelops in increasing order by width then in decreasing order by height if the widths are equal.  
*/

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length, ans = 1;
        int[] tails = new int[n];
        int size = 0;
        
        Arrays.sort(envelopes, (a,b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);    

        for (int i = 0; i < n; i++) {
            int position = search(envelopes[i][1], tails, size);
            
            if(position >= size) tails[size++] = envelopes[i][1];
            else tails[position] = envelopes[i][1];
        }
        
        return size;
    }

    private int search(int height, int[] tails, int size){
        int left = 0, right = size-1, ans = -1;

        while(left <= right){
            int mid = (left+right)/2;
            if(tails[mid] < height){
                ans = mid;
                left = mid+1;
            }
            else right = mid - 1;
        }

        return ans+1;
    }

}