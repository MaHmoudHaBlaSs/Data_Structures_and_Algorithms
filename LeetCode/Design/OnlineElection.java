/// https://leetcode.com/problems/online-election/

class TopVotedCandidate {
   private int[] times, lead, count;

    public TopVotedCandidate(int[] persons, int[] times) {
        this.times = times;
        count = new int[persons.length]; 
        lead = new int[persons.length]; 
        
        lead[0] = persons[0]; 
        count[persons[0]] = 1; 
        
        for(int i=1; i<persons.length; i++){
            count[persons[i]]++;

            if(count[persons[i]] >= count[lead[i-1]])
                lead[i] = persons[i];
            else
                lead[i] = lead[i-1];
        }
    }
    
    public int q(int t) {
        int l = 0, r = times.length - 1, ans = 0;
        
        while (l <= r) {
            int mid = (l + r) / 2;
            if (times[mid] <= t) {
                ans = mid;
                l = mid+1;
            } else {
                r = mid - 1;
            }
        }
        
        return lead[ans];
    }
}
