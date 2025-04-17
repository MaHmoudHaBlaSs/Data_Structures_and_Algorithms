// https://leetcode.com/problems/maximum-units-on-a-truck/

// Optimal.
// The main factor that affects time complexity is the sorting algorithm used.
// T: O(nLog(n))                S: O(1)
class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int load = 0;
        
        // Sorting

        // Sorting
        // sortBoxes(boxTypes); // O(n^2)
        Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[1], a[1])); // O(nLog(n))
        
        for (int i = 0; i < boxTypes.length; i++){
            int boxes = boxTypes[i][0], units = boxTypes[i][1];

            if (boxes <= truckSize){
                load += boxes * units;
                truckSize -= boxes;
            }else{
                load += truckSize * units;
                truckSize = 0;
                break;
            }
        }
        return load;
    }

    public void sortBoxes(int[][] boxTypes){
        for (int i = 0; i < boxTypes.length; i++) {
            int max = i;
            for (int j = i+1; j < boxTypes.length; j++){
                if (boxTypes[j][1] > boxTypes[max][1])
                    max = j;
            }
            if (max != i)
                swapBoxes(boxTypes, i, max);
        }
    }
    public void swapBoxes(int[][] boxTypes, int a, int b){
        int[] tempBoxA = boxTypes[a];
        boxTypes[a] = boxTypes[b];
        boxTypes[b] = tempBoxA;
    }
}