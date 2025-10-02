// https://leetcode.com/problems/number-of-laser-beams-in-a-bank/

class Solution {
    public int numberOfBeams(String[] bank) {
    int prev = 0; 
    int total = 0;
    
    for (String floor : bank) {
        int curr = countOfLaser(floor);
        if (curr > 0) {
            total += prev * curr; 
            prev = curr;
        }
    }
    return total;
    }
	public int countOfLaser(String floor){
		int count = 0 ;
		for(char c : floor.toCharArray()){
			if(c == '1' )
				count++;
		}
		return count;
	}
}