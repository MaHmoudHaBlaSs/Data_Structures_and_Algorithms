///  https://leetcode.com/problems/filter-occupied-intervals/description/

class Solution {
    public List<List<Integer>> filterOccupiedIntervals(int[][] occupiedIntervals, int freeStart, int freeEnd) {
        Arrays.sort(occupiedIntervals, (a,b) -> a[0] - b[0]);
        List<List<Integer>> ans = new ArrayList<>(); 

        for(int[] interval : occupiedIntervals){
            //merge
            if(ans.isEmpty() || interval[0] > ans.getLast().get(1) + 1){
                List<Integer> list = new ArrayList<>(List.of(interval[0], interval[1]));
                ans.add(list);
            }else{
                ans.getLast().set(1, Integer.max(ans.getLast().get(1), interval[1]));
            }

            //1. check if the whole interval inside the free time
            if(ans.getLast().get(0) >= freeStart && ans.getLast().get(1) <= freeEnd){
                ans.removeLast();
            }
            //2. check if whole free time inside the interval
            else if(freeStart >= ans.getLast().get(0) && freeEnd <= ans.getLast().get(1)){
                var removed = ans.removeLast();
                if(removed.get(0) < freeStart){
                    ans.add(new ArrayList<>(List.of(removed.get(0), freeStart-1)));
                }
                if(removed.get(1) > freeEnd){
                    ans.add(new ArrayList<>(List.of(freeEnd+1, removed.get(1))));
                }
            }              
            //3. check if the last part of the last interval is in free time
            else if(ans.getLast().get(1) >= freeStart && ans.getLast().get(1) <= freeEnd){
                ans.getLast().set(1, freeStart-1);
            }
            //4. check if the first part of the last interval is in free time
            else if(ans.getLast().get(0) >= freeStart && ans.getLast().get(0) <= freeEnd){
                ans.getLast().set(0, freeEnd+1);
            }
        }

        return ans;

    }
}