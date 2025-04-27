///  https://leetcode.com/problems/rle-iterator/description/

class RLEIterator {
    private int[] encoding; 
    private int it = 0;
    
    public RLEIterator(int[] encoding) {
        this.encoding = encoding;
    }
    
    public int next(int n) {
        while(it < encoding.length && n > encoding[it]){
            n -= encoding[it]; 
            it += 2;
        }

        if(it >= encoding.length)
            return -1;

        if(n == encoding[it]){
            it += 2;
            return encoding[it-1];
        }
        else {
            encoding[it] -= n;
            return encoding[it+1]; 
        }
    }
}