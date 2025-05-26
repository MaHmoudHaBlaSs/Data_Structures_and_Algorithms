///  https://leetcode.com/problems/longest-uploaded-prefix/description/

class LUPrefix {
    private boolean[] isUploaded;
    private int i=0, n=0;
    public LUPrefix(int n) {
        isUploaded = new boolean[n+1];
        this.n = n;
    }
    
    public void upload(int video) {
        isUploaded[video] = true;
        while(i+1 <= n && isUploaded[i+1]) i++;
    }
    
    public int longest() {
        return i;
    }
}