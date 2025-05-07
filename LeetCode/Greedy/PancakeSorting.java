///   https://leetcode.com/problems/pancake-sorting/description/

/* 
    From the unsorted portion of the array, find the largest element.
    Flip it to the front of the array (if it's not already there).
    Then flip the entire unsorted portion to move that largest element to its correct position at the end.
    Reduce the size of the unsorted portion by 1 and repeat.
*/

class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> ans = new ArrayList<>(); 
        int end = arr.length; 

        for(int i=0; i<arr.length; i++){
            end--;
            int max = maxIndex(arr, end);
            
            if(max == end) continue; 

            if(max != 0) {
                flip(arr, max);
                ans.add(max+1);
            }
            
            flip(arr, end);
            ans.add(end+1);
        }

        return ans; 
    }

    private int maxIndex(int[] arr, int end){
        int ans = 0;
        
        for(int i=1; i<=end; i++)
            if(arr[i] > arr[ans]) ans = i;

        return ans;
    }

    private void flip(int[] arr,int end){
        int start = 0; 
        while(start < end){
            int tmp = arr[start]; 
            arr[start] = arr[end]; 
            arr[end] = tmp;

            start++; end--; 
        }
    }
}