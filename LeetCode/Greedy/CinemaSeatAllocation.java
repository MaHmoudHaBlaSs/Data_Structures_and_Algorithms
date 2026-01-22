/// https://leetcode.com/problems/cinema-seat-allocation/description/


class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int ans =2*n, len = reservedSeats.length; 
        Arrays.sort(reservedSeats, (a,b) -> a[0]-b[0]);

        for (int i=0; i<len; ){
            boolean validLeft = true, validRight=true, validMiddle=true;
            int j=i-1; 
            while(j+1<len && reservedSeats[j+1][0] == reservedSeats[i][0]){
                ++j;
                int col = reservedSeats[j][1];
                validLeft = validLeft && !breaksLeftSide(col);  
                validRight = validRight && !breaksRightSide(col);  
                validMiddle = validMiddle && !breaksMiddle(col);  
            }
            i=j+1;

            if(!validMiddle){
                --ans;
                if(!validLeft && !validRight) --ans;
            }
            else if(!validLeft || !validRight) --ans;
        }

        return ans; 
    }

    private boolean breaksLeftSide(int col){
        return (col > 1 && col < 6);
    }
    private boolean breaksRightSide(int col){
        return (col > 5 && col < 10);
    }

    private boolean breaksMiddle(int col){
        return col > 3 && col < 8;
    }
}