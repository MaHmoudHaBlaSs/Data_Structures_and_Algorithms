// https://leetcode.com/problems/boats-to-save-people/description/

// Optimal.
// T: O(nlog(n))             S: O(1)
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int left = 0, right = people.length-1, boats = 0;
        Arrays.sort(people);
        
        while (left < right){
            if (people[left] + people[right] > limit) right--;
            else {
                right--;
                left++;
            }
            boats++;
        }
        if (left == right) boats++;
        return boats;
    }
}