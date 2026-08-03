///  https://leetcode.com/problems/utf-8-validation/description/

class Solution {
    private final int[] arr = new int[]{ 0B0, 0B11000000, 0B11100000, 0B11110000, 0B10000000};
    private final int[] masks = new int[]{ 1<<7, 0B11100000, 0B11110000, 0B11111000, 0B11000000};

    public boolean validUtf8(int[] data) {
        int n = data.length; 

        for(int i=0; i<n; ++i){
            boolean valid = false;

            for(int j=0; j<4; ++j){
                if((masks[j] & data[i]) == arr[j]){
                    if(i+j >= n) return false;

                    for(int k=0; k<j; ++k){
                        if((masks[4] & data[i+k+1]) != arr[4])  
                            return false;
                    }
                    i += j;
                    valid = true;
                    break;
                }
            }

            if(!valid) return false; 
        }

        return true;
    }
}