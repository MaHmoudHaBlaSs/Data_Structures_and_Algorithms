///  https://leetcode.com/problems/maximum-manhattan-distance-after-k-changes/description/

class Solution {
    public int maxDistance(String s, int k) {
        int north = 0, south = 0, east = 0, west=0, kTmp = k;
        int ans = 0;

        for(int i=0; i<s.length(); i++){
            switch(s.charAt(i)){
                case 'N':
                    north++; 
                    break;
                case 'S':
                    south++;
                    break;
                case 'E':
                    east++;
                    break;
                default:
                    west++;
            }

            kTmp = k;
            int nNorth = north, nSouth = south, nEast = east, nWest = west;
            if(north > south){
                int changed = Math.min(kTmp, south);
                nSouth -= changed;
                nNorth += changed;
                kTmp -= changed;
            }  
            else {
                int changed = Math.min(kTmp, north);
                nSouth += changed;
                nNorth -= changed;
                kTmp -= changed;               
            }

            if(east > west){
                int changed = Math.min(kTmp, west);
                nWest -= changed;
                nEast += changed;
                kTmp -= changed;
            }  
            else {
                int changed = Math.min(kTmp, east);
                nWest += changed;
                nEast -= changed;
                kTmp -= changed;               
            }

            ans = Math.max(ans, Math.abs(nNorth - nSouth) + Math.abs(nEast - nWest));
        }

        return ans;
    }
}