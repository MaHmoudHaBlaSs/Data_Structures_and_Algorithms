// https://leetcode.com/problems/insert-delete-getrandom-o1/description/


class RandomizedSet {
    private Set<Integer> set ;
    private List<Integer> list;
    private Random rand;
    
    public RandomizedSet() {
        set = new HashSet<>();
        list = new ArrayList<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        boolean added = set.add(val);
        if (added) {
            list.add(val);
        }
        return added;
    }
    
    public boolean remove(int val) {
        boolean removed = set.remove(val);
        if (removed) {
            list.remove(Integer.valueOf(val));
        }
        return removed;
    }

    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}