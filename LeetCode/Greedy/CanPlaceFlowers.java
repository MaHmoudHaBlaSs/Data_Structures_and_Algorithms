// https://leetcode.com/problems/can-place-flowers/description/

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed.length >= 1 && flowerbed[0] == 0 && (flowerbed.length == 1 || flowerbed[1] == 0) && n > 0) {
            flowerbed[0] = 1;
            n--;
        }

        for (int i = 1; i < flowerbed.length - 2; i++) {
            if(flowerbed[i] == 0 && flowerbed[i+1] == 0 && flowerbed[i-1] == 0 && n > 0){
                flowerbed [i] = 1;
                n--;
            }
        }

        int last = flowerbed.length - 1;
        if (flowerbed.length >= 2 && flowerbed[last] == 0 && flowerbed[last - 1] == 0 && n > 0) {
            flowerbed[last] = 1;
            n--;
        }


        return n <= 0;
    }
}
