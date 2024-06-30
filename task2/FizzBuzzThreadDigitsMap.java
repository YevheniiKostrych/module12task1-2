package module12.task2;

import java.util.concurrent.atomic.AtomicInteger;

public class FizzBuzzThreadDigitsMap {
    private final int n;
    private final AtomicInteger current = new AtomicInteger(1);
    private final Object lock = new Object();

    public FizzBuzzThreadDigitsMap(int n) {
        this.n = n;
    }

    public void fizz() {
        while (true) {
            synchronized (lock) {
                while (current.get() <= n && (current.get() % 3 != 0 || current.get() % 5 == 0)) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                if (current.get() > n) return;
                System.out.print("fizz");
                if (current.get() < n) {
                    System.out.print(", ");
                }
                current.incrementAndGet();
                lock.notifyAll();
            }
        }
    }

    public void buzz() {
        while (true) {
            synchronized (lock) {
                while (current.get() <= n && (current.get() % 5 != 0 || current.get() % 3 == 0)) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                if (current.get() > n) return;
                System.out.print("buzz");
                if (current.get() < n) {
                    System.out.print(", ");
                }
                current.incrementAndGet();
                lock.notifyAll();
            }
        }
    }

    public void fizzbuzz() {
        while (true) {
            synchronized (lock) {
                while (current.get() <= n && (current.get() % 3 != 0 || current.get() % 5 != 0)) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                if (current.get() > n) return;
                System.out.print("fizzbuzz");
                if (current.get() < n) {
                    System.out.print(", ");
                }
                current.incrementAndGet();
                lock.notifyAll();
            }
        }
    }

    public void number() {
        while (true) {
            synchronized (lock) {
                while (current.get() <= n && (current.get() % 3 == 0 || current.get() % 5 == 0)) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                if (current.get() > n) return;
                System.out.print(current.get());
                if (current.get() < n) {
                    System.out.print(", ");
                }
                current.incrementAndGet();
                lock.notifyAll();
            }
        }
    }
}
