///     https://leetcode.com/problems/check-if-grid-can-be-cut-into-sections/description/

//T: O(n.log(n))     S:O(1)
class Solution {
    public boolean checkValidCuts(int n, int[][] arr) {
        int len = arr.length;
        
        //sort by y and check if you can
        Arrays.sort(arr, (rect1,rect2) -> rect1[1] - rect2[1]); 
        int horizontal = 0; 
        for(int i=0;i<len; i++){
            int startY = arr[i][1], maxEndY = arr[i][3];
            while(i+1 < len && (arr[i+1][1] >= startY && arr[i+1][1] < maxEndY)){
                i++; 
                maxEndY = Math.max(maxEndY, arr[i][3]); 
            }
            horizontal++; 
        }
        if(horizontal >= 3) return true; 

        //sort by x and check if you can
        Arrays.sort(arr, (rect1,rect2) -> rect1[0] - rect2[0]); 
        int vertical = 0; 
        for(int i=0;i<len; i++){
            int startX = arr[i][0], maxEndX = arr[i][2];
            while(i+1 < len && (arr[i+1][0] >= startX && arr[i+1][0] < maxEndX)){
                i++; 
                maxEndX = Math.max(maxEndX, arr[i][2]); 
            }
            vertical++; 
            
        }
        if(vertical >= 3) return true; 
        
        return false;
    }
}