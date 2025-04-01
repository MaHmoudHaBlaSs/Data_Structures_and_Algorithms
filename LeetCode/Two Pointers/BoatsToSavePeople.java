/// https://leetcode.com/problems/boats-to-save-people/

// Greedy approach is to take a heavy person with a thin person (if possible) 

// Optimal.
// T: O(N.log(N))              S:O(1)
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people); 
        int l=0, r = people.length-1; 
        int c=0;

        while(l <= r){
            int curr = people[r--]; 
            if(r >= l && curr + people[l] <= limit) 
                curr += people[l++];

            c++;
        }

        return c;
    }
}