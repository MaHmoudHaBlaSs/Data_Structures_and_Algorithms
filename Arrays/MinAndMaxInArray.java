// https://www.geeksforgeeks.org/maximum-and-minimum-in-an-array/

class Solution {
    public Pair<Integer, Integer> getMinMax(int[] arr) {
        int min = arr[0], max = arr[0];
        for (int num: arr){
            if (num > max)
                max = num;
            if (num < min)
                min = num;
        }
        return new Pair(min, max);
    }
}
