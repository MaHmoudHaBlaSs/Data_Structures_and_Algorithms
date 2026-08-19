///  https://leetcode.com/problems/building-h2o/description/

class H2O {
    private final Semaphore h = new Semaphore(2);
    private final Semaphore o = new Semaphore(0);
    
    public H2O() {
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        h.acquire();
        
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        
        o.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        o.acquire(2);
        
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        
        h.release(2);
    }
}