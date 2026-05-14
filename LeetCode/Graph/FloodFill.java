// https://leetcode.com/problems/flood-fill/description/ 


class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];
        if (originalColor == color) return image; // No need to fill if the color is the same

        dfsFill(image, sr, sc, originalColor, color);
        return image;
    }
    public void dfsFill(int[][] image, int sr, int sc,int originalColor, int color){
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length) return; // Out of bounds
        if (image[sr][sc] != originalColor) return; // Different color, stop filling
        
        image[sr][sc] = color;
        
        dfsFill(image,sr,sc+1,originalColor,color);
        dfsFill(image,sr,sc-1,originalColor,color);
        dfsFill(image,sr+1,sc,originalColor,color);
        dfsFill(image,sr-1,sc,originalColor,color);
    }
}