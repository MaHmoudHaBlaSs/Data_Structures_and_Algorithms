///  https://leetcode.com/problems/design-auction-system/description/


class AuctionSystem {

    private static class Bid {
        int userId;
        int amount;

        Bid(int userId, int amount) {
            this.userId = userId;
            this.amount = amount;
        }
    }

    // itemId -> (userId -> amount)
    private final Map<Integer, Map<Integer, Integer>> bids;

    // itemId -> ordered bids
    private final Map<Integer, TreeSet<Bid>> itemRanks;

    public AuctionSystem() {
        bids = new HashMap<>();
        itemRanks = new HashMap<>();
    }

    private TreeSet<Bid> getTree(int itemId) {
        return itemRanks.computeIfAbsent(itemId, k ->
            new TreeSet<>((a, b) -> {
                if (a.amount != b.amount)
                    return Integer.compare(b.amount, a.amount);

                return Integer.compare(b.userId, a.userId);
            })
        );
    }

    public void addBid(int userId, int itemId, int bidAmount) {
        bids.putIfAbsent(itemId, new HashMap<>());

        Map<Integer, Integer> itemMap = bids.get(itemId);
        TreeSet<Bid> tree = getTree(itemId);

        if (itemMap.containsKey(userId)) {
            int oldAmount = itemMap.get(userId);
            tree.remove(new Bid(userId, oldAmount));
        }

        itemMap.put(userId, bidAmount);
        tree.add(new Bid(userId, bidAmount));
    }

    public void updateBid(int userId, int itemId, int newAmount) {
        Map<Integer, Integer> itemMap = bids.get(itemId);
        TreeSet<Bid> tree = itemRanks.get(itemId);

        int oldAmount = itemMap.get(userId);

        tree.remove(new Bid(userId, oldAmount));

        itemMap.put(userId, newAmount);

        tree.add(new Bid(userId, newAmount));
    }

    public void removeBid(int userId, int itemId) {
        Map<Integer, Integer> itemMap = bids.get(itemId);
        TreeSet<Bid> tree = itemRanks.get(itemId);

        int amount = itemMap.get(userId);

        tree.remove(new Bid(userId, amount));
        itemMap.remove(userId);

        if (itemMap.isEmpty()) {
            bids.remove(itemId);
            itemRanks.remove(itemId);
        }
    }

    public int getHighestBidder(int itemId) {
        TreeSet<Bid> tree = itemRanks.get(itemId);

        if (tree == null || tree.isEmpty())
            return -1;

        return tree.first().userId;
    }
}