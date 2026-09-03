// https://leetcode.com/problems/count-covered-buildings/

class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {

        Map<Integer,TreeSet<Integer>> rows = new HashMap<>();
        Map<Integer,TreeSet<Integer>> cols = new HashMap<>();
        for (int[] building : buildings) {
            int x = building[0];
            int y = building[1];

            if(!rows.containsKey(x)) rows.put(x,new TreeSet<>());
            if(!cols.containsKey(y)) cols.put(y,new TreeSet<>());

            rows.get(x).add(y);
            cols.get(y).add(x);

        }

        int coveredCount = 0;

        for (int[] building : buildings) {
            int x = building[0];
            int y = building[1];


            boolean hasAbove = cols.get(y).lower(x) != null;
            boolean hasBelow = cols.get(y).higher(x) != null;
            boolean hasLeft = rows.get(x).lower(y) != null;
            boolean hasRight = rows.get(x).higher(y) != null;
            
            if (hasAbove && hasBelow && hasLeft && hasRight) {
                coveredCount++;
            }
            
        }
        return coveredCount;
    }
}