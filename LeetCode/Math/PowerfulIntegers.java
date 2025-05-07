///   https://leetcode.com/problems/powerful-integers/description/

class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        List<Integer> xPowers = getPowers(x, bound); 
        List<Integer> yPowers =  (x == y ? xPowers : getPowers(y, bound));

        HashSet<Integer> set = new HashSet<>(); 
        for(int xPower : xPowers) {
            for(int yPower : yPowers)
                if(xPower + yPower <= bound) set.add(xPower + yPower);
        } 

        return new ArrayList<>(set); 
    }

    private List<Integer> getPowers(int num, int bound){
        List<Integer> powers = new ArrayList<>();

        if(num == 1) {
            powers.add(1);
            return powers;
        }

        int m = 1;
        while(m <= bound) {
            powers.add(m);
            m *= num; 
        }
        return powers;
    } 
}