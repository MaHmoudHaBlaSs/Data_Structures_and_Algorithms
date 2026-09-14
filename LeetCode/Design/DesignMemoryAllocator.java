///  https://leetcode.com/problems/design-memory-allocator/description/

class Allocator {
    private int[] mem;

    public Allocator(int n) {
        mem = new int[n];    
    }
    
    public int allocate(int size, int mID) {
        int av = 0;
        for(int i=0; i<mem.length; ++i){
            if(mem[i] == 0) av++;
            else av = 0;

            if(av == size){
                for(int j=i-size+1; j<=i; ++j){
                    mem[j] = mID; 
                }
                return i-size+1;
            }
        }

        return -1;
    }
    
    public int freeMemory(int mID) {
        int c = 0;
        for(int i=0; i<mem.length; ++i){
            if(mem[i] == mID){
                c++;
                mem[i] = 0;
            }
        }       

        return c; 
    }
}