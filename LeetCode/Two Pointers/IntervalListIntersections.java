///   https://leetcode.com/problems/interval-list-intersections/description/


class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int n = firstList.length, m = secondList.length;
        int j=0, i=0;
        ArrayList<int[]> list = new ArrayList<>();

        while(j<m && i<n) {
            
            if((firstList[i][0] >= secondList[j][0] && firstList[i][0] <= secondList[j][1])
                || (secondList[j][0] >= firstList[i][0] && secondList[j][0] <= firstList[i][1])){
                list.add(new int[]{Math.max(firstList[i][0], secondList[j][0]), Math.min(firstList[i][1], secondList[j][1])});
            }
            
            if(firstList[i][1] < secondList[j][1]) i++;
            else j++;
        }  

        return  list.toArray(new int[list.size()][]); 
    }
}