--> https://leetcode.com/problems/trapping-rain-water/description/

public static int trap(int[] height) {
        int l = 0, r = height.length - 1;
        int waterCount = 0, maxLeft = 0, maxRight = 0;

        while (l < r) {
            if (height[l] < height[r]) { 
                maxLeft = Math.max(maxLeft, height[l]);
                waterCount += Math.max(0, maxLeft - height[l]);
                l++;
            } else { 
                maxRight = Math.max(maxRight, height[r]);
                waterCount += Math.max(0, maxRight - height[r]);
                r--;
            }
        }

        return waterCount;
    }
