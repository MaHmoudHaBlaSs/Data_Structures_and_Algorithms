/// https://leetcode.com/problems/closest-room/description/

/*
Instead of finding the most suitable room for each query:
    for each room --> find all queries such that the room can be a solution for each of those queries.  

1-Sort queries based on minSize of each query.
2-For each room --> find the query largest minSize <= roomSize, [the current room can be an answer for all queries with minSize <= roomSize]
3-Iterate from the left of sorted queries so that if room is valid for queries[j], it's also valid for queries[i], where i < j 
*/

class Solution {
    public int[] closestRoom(int[][] rooms, int[][] queries) {
        int m = queries.length;
        int[] ans = new int[m];
        Arrays.fill(ans, -1);

        int[][] queriesWithIndex = new int[m][3];
        for (int i = 0; i < m; i++) {
            queriesWithIndex[i][0] = queries[i][0];
            queriesWithIndex[i][1] = queries[i][1];
            queriesWithIndex[i][2] = i;
        }
        Arrays.sort(queriesWithIndex, Comparator.comparingInt(a -> a[1]));

        ArrayList[] validRoomsForQuery = validRoomsForEachQuery(queriesWithIndex, rooms);

        TreeSet<Integer> validRooms = new TreeSet<>();
        for (int i = m-1; i >= 0; --i) {
            if(validRoomsForQuery[i] != null) validRooms.addAll(validRoomsForQuery[i]);
            if(validRooms.isEmpty()) continue;

            int preferred = queriesWithIndex[i][0];
            ans[queriesWithIndex[i][2]] = closestToTarget(
                    validRooms.ceiling(preferred), 
                    validRooms.floor(preferred), 
                    preferred
            );
        }
        return ans;
    }

    private ArrayList[] validRoomsForEachQuery(int[][] sortedQueries, int[][] rooms){
        ArrayList[] validRoomsForQuery = new ArrayList[sortedQueries.length];
        for(int[] room : rooms) {
            int lastValidQueryIndex = lastIndexOfValidQueries(sortedQueries, room[1]);
            if (lastValidQueryIndex != -1) {
                if(validRoomsForQuery[lastValidQueryIndex] == null)
                    validRoomsForQuery[lastValidQueryIndex] = new ArrayList<Integer>();

                validRoomsForQuery[lastValidQueryIndex].add(room[0]);
            }
        }
        return validRoomsForQuery;      
    }

    private int lastIndexOfValidQueries(int[][] sortedQueries, int roomSize){
        int left = 0, right = sortedQueries.length - 1;
        int lastValidQueryIndex = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (sortedQueries[mid][1] <= roomSize) {
                lastValidQueryIndex = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return lastValidQueryIndex;
    }

    private int closestToTarget(Integer candidate1, Integer candidate2, int target) {
        int ans = -1;
        if(candidate2 == null) ans = candidate1;
        else if(candidate1 == null) ans = candidate2;
        else {
            int diff1 = Math.abs(target - candidate1), diff2 = Math.abs(target - candidate2);
            if(diff1 < diff2) ans = candidate1;
            else if(diff2 < diff1) ans = candidate2;
            else ans = Math.min(candidate1, candidate2);
        }

        return ans;
    }
}