///  https://leetcode.com/problems/longest-almost-palindromic-substring/description/

class Solution {
    public int almostPalindromic(String s) {
        int ans = 2, n=s.length();

        for(int i=0; i<n; ++i){
            //case 1: even length
            int l=i, r=i+1, violationL = -1, violationR=-1;
            while(l>= 0 && r<n){
                if(s.charAt(l) != s.charAt(r)){
                    if(violationL == -1) {
                        violationL = l;
                        violationR = r;
                        r--;
                    }
                    else{
                        break;
                    }
                }else{
                    ans = Integer.max(ans, r-l+(violationL == -1 && (r-l+1)<n? 2:1));
                }

                r++;
                l--;
            }

            if(violationL != -1){
                l = violationL; r = violationR+1;
                while(l>= 0 && r<n){
                    if(s.charAt(l) != s.charAt(r)){
                        break;
                    }else{
                        ans = Integer.max(ans, r-l+1);
                    }
                    r++;
                    l--;
                }
            }

            //case 2: odd length
            l=i-1; r=i+1; violationL = -1; violationR=-1;
            while(l>= 0 && r<n){
                if(s.charAt(l) != s.charAt(r)){
                    if(violationL == -1) {
                        violationL = l;
                        violationR = r;
                        r--;
                    }
                    else{
                        break;
                    }
                }else{
                    ans = Integer.max(ans, r-l+(violationL == -1 && (r-l+1)<n? 2:1));
                }

                r++;
                l--;
            }

            if(violationL != -1){
                l = violationL; r = violationR+1;
                while(l>= 0 && r<n){
                    if(s.charAt(l) != s.charAt(r)){
                        break;
                    }else{
                        ans = Integer.max(ans, r-l+1);
                    }
                    r++;
                    l--;
                }
            }
        }

        return ans;
    }
}
