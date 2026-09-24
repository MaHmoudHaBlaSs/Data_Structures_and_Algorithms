// https://leetcode.com/problems/filter-restaurants-by-vegan-friendly-price-and-distance/description/

class Solution {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        Arrays.sort(restaurants, (a, b) ->{
                if (a[1] != b[1]) {
                    return Integer.compare(b[1], a[1]); 
                } else {
                    return Integer.compare(b[0], a[0]); 
                }
        } );
        List<Integer> result = new ArrayList<>();
        for (int[] restaurant : restaurants) {
            int id = restaurant[0];
            int rating = restaurant[1];
            boolean isVeganFriendly = restaurant[2] == 1;
            int price = restaurant[3];
            int distance = restaurant[4];
            

            if (veganFriendly == 1 && !isVeganFriendly) {
                continue;
            }
            if (price > maxPrice || distance > maxDistance) {
                continue;
            }
            result.add(id);
        }
        return result;
    }
}