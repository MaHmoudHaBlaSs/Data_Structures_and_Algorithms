// https://leetcode.com/problems/design-authentication-manager/description/

class AuthenticationManager {
    private Map<String,Integer> map;
    private int timeToLive;
    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
        map = new HashMap<>();
    }

    public void generate(String tokenId, int currentTime) {
        map.put(tokenId, (currentTime+timeToLive) );
    }

    public void renew(String tokenId, int currentTime) {
        if(map.containsKey(tokenId) && map.get(tokenId) > currentTime){
            map.put(tokenId,currentTime+timeToLive);
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        int count = 0;
        for(String key : map.keySet()){
            if(map.get(key) > currentTime) count++;
        }
        return count;
    }
}