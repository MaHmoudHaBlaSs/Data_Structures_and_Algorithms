///   https://leetcode.com/problems/largest-time-for-given-digits/


class Solution {
    private String st = "";
    private boolean[] vis;

    private void solve(int[] arr, int index, String s){
        if(index == 4){
            if(st.isEmpty() || larger(s)) 
                st = s;
            
            return ;
        }

        for(int i=0; i<4; i++){
            if(vis[i]) continue; 

            if(index == 0){
                if(arr[i] < 3) {
                    vis[i] = true; 
                    solve(arr, index+1, s + Integer.toString(arr[i]) ); 
                    vis[i] = false; 
                }
            }
            else if(index == 1){
                if(s.charAt(0) == '2') {
                    if(arr[i] < 4) {
                        vis[i] = true; 
                        solve(arr, index+1, s + Integer.toString(arr[i]) ); 
                        vis[i] = false; 
                    }
                }
                else {
                    vis[i] = true; 
                    solve(arr, index+1, s + Integer.toString(arr[i])); 
                    vis[i] = false; 
                }                
            }else if(index == 2){
                if(arr[i] < 6) {
                    vis[i] = true; 
                    solve(arr, index+1, s + Integer.toString(arr[i]) ); 
                    vis[i] = false; 
                }
            }else{
                vis[i] = true; 
                solve(arr, index+1, s + Integer.toString(arr[i]) ); 
                vis[i] = false; 

            }
        }
    }

    private boolean larger (String s){
        int hourS = Integer.parseInt(s.substring(0,2)); 
        int minS = Integer.parseInt(s.substring(2));
        
        int hourSt = Integer.parseInt(st.substring(0,2)); 
        int minSt = Integer.parseInt(st.substring(2));

        if(hourS > hourSt || (hourS == hourSt && minS > minSt)) return true;

        return false;
    }

    public String largestTimeFromDigits(int[] arr) {
        vis = new boolean[4];
        solve(arr,0, ""); 
        return st.isEmpty() ? st : st.substring(0,2) + ":" + st.substring(2);
    }
}