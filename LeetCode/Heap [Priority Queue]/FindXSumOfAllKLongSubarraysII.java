///  https://leetcode.com/problems/find-x-sum-of-all-k-long-subarrays-ii/description/

class Solution {
    private final Comparator<Element> cmp = (a, b) -> {
        if (a.count != b.count) {
            return Integer.compare(b.count, a.count);
        }
        return Integer.compare(b.val, a.val);
    };

    private final TreeSet<Element> xSet = new TreeSet<>(cmp);
    private final TreeSet<Element> remainingSet = new TreeSet<>(cmp);
    private final Map<Integer, Integer> freqMap = new HashMap<>();
    private long currentSum = 0;
    private int xLimit;

    public long[] findXSum(int[] nums, int k, int x) {
        this.xLimit = x;
        int n = nums.length;
        long[] ans = new long[n - k + 1];

        for (int i = 0; i < k; i++) {
            addElement(nums[i]);
        }

        balanceSets();
        ans[0] = currentSum;

        for (int i = k; i < n; i++) {
            addElement(nums[i]);
            removeElement(nums[i - k]);
            balanceSets();
            ans[i - k + 1] = currentSum;
        }

        return ans;
    }

    static class Element {
        int val;
        int count;

        Element(int val, int count) {
            this.val = val;
            this.count = count;
        }
    }

    private void addElement(int val) {
        int oldFreq = freqMap.getOrDefault(val, 0);
        int newFreq = oldFreq + 1;
        freqMap.put(val, newFreq);

        if (oldFreq > 0) {
            removeEntry(new Element(val, oldFreq));
        }
        insertEntry(new Element(val, newFreq));
    }

    private void removeElement(int val) {
        int oldFreq = freqMap.get(val);
        int newFreq = oldFreq - 1;

        removeEntry(new Element(val, oldFreq));

        if (newFreq > 0) {
            freqMap.put(val, newFreq);
            insertEntry(new Element(val, newFreq));
        } else {
            freqMap.remove(val);
        }
    }

    private void insertEntry(Element e) {
        xSet.add(e);
        currentSum += (long) e.val * e.count;

        if (xSet.size() > xLimit) {
            Element demote = xSet.pollLast();
            currentSum -= (long) demote.val * demote.count;
            remainingSet.add(demote);
        }
    }

    private void removeEntry(Element e) {
        if (xSet.remove(e)) {
            currentSum -= (long) e.val * e.count;

            if (!remainingSet.isEmpty()) {
                Element promote = remainingSet.pollFirst();
                xSet.add(promote);
                currentSum += (long) promote.val * promote.count;
            }
        } else {
            remainingSet.remove(e);
        }
    }

    private void balanceSets() {
        while (!remainingSet.isEmpty() && xSet.size() < xLimit) {
            Element promote = remainingSet.pollFirst();
            xSet.add(promote);
            currentSum += (long) promote.val * promote.count;
        }

        while (!remainingSet.isEmpty() && !xSet.isEmpty() && cmp.compare(remainingSet.first(), xSet.last()) < 0) {
            Element promote = remainingSet.pollFirst();
            Element demote = xSet.pollLast();

            currentSum += (long) promote.val * promote.count;
            currentSum -= (long) demote.val * demote.count;

            xSet.add(promote);
            remainingSet.add(demote);
        }
    }    
}