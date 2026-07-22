// https://leetcode.com/problems/find-building-where-alice-and-bob-can-meet/

public class FindBuildingWhereAliceAndBobCanMeet {
    // Instead of trying to solve each query as a separate problem we will try another prespective
    // Think of it as while traversing buildings ask yourself "can this current building solve any query"
    // by this mindset we are solving all queries at the same algorithm, not running an algorithm for each one.

    public int[] leftmostBuildingQueries(int[] building, int[][] rawQueries) {
        int n = building.length; int qn = rawQueries.length;
        int[] res = new int[qn];
        Arrays.fill(res, -1);

        // Each building has queries flags (needed to be solved) that appears when building is traversed.
        // Query flag is defined by [heightNeeded, queryInd]
        List<List<int[]>> queriesFlags = new ArrayList<>(n); 
        for (int i = 0; i < n; i++)
            queriesFlags.add(new LinkedList<>());

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparing(a -> a[0]));

        for (int q = 0; q < qn; q++) {
            int a = rawQueries[q][0]; int b = rawQueries[q][1]; // alice, bob
            
            // Special cases that don't need search
            if ( a < b && building[a] < building[b])
                res[q] = b;
            else if ( a > b && building[a] > building[b])
                res[q] = a;
            else if ( a == b )
                res[q] = a;
            // for this kind of queries we need to search for the next leftmost (nearest) greater building
            else 
                queriesFlags.get(Math.max(a, b)).add( new int[]{ Math.max(building[a], building[b]), q } );
        }

        // We now have ansered easy queries and have queries' flags for those who need search
        // Traverse buildings and add queries' flags when their building comes.
        for ( int i = 0; i < n; i++){
            while ( !minHeap.isEmpty() && building[i] > minHeap.peek()[0] )
                res[minHeap.poll()[1]] = i;

            // Before moving from the current building add its queries flags to the heap
            // this is logical because any query starts from current building its answer must be 
            // in a later next building. 
            for ( int[] flag: queriesFlags.get(i))
                minHeap.add(flag);
        }

        return res;
    }
}
