// https://leetcode.com/problems/print-foobar-alternately/description/


class FooBar {
    private int n;
    private boolean fooTurn = true;
    private final Object lock = new Object();

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                while (!fooTurn) {
                    lock.wait();
                }
                printFoo.run();
                fooTurn = false;
                lock.notifyAll(); // Wake up the bar thread (which is waiting)
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                while (fooTurn) {
                    lock.wait();
                }
                printBar.run();
                fooTurn = true;
                lock.notifyAll();
            }
        }
    }
}