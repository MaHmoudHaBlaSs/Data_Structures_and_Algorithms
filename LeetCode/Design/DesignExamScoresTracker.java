///  https://leetcode.com/problems/design-exam-scores-tracker/description/

class ExamTracker {
    private ArrayList<long[]> list = new ArrayList<>();

    public ExamTracker() {
        list.add(new long[]{0,0});    
    }
    
    public void record(int time, int score) {
        list.add(new long[]{time, score + list.getLast()[1]});
    }
    
    public long totalScore(int startTime, int endTime) {
        int idx1 = binarySearch(startTime-1);
        int idx2 = binarySearch(endTime);

        return list.get(idx2)[1] - list.get(idx1)[1];
    }

    private int binarySearch(long time){
        int ans = 0;
        int l = 0, r = list.size()-1;

        while(l<=r){
            int mid = (l+r) >> 1;

            if(list.get(mid)[0] <= time){
                ans = mid;
                l = mid+1;
            }else r = mid - 1;
        }

        return ans;
    }
}
