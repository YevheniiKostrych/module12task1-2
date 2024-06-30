package module12.task2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class FizzBuzzThreadDigitsMap {
    private final int n;
    private final AtomicInteger current;
    private final BlockingQueue<String> queue;

    public FizzBuzzThreadDigitsMap(int n) {
        this.n = n;
        this.current = new AtomicInteger(1);
        this.queue = new LinkedBlockingQueue<>();
    }

    public void fizz() {
        while (true) {
            int num = current.get();
            if (num > n) break;
            if (num % 3 == 0 && num % 5 != 0) {
                try {
                    queue.put("fizz");
                    current.incrementAndGet();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public void buzz() {
        while (true) {
            int num = current.get();
            if (num > n) break;
            if (num % 5 == 0 && num % 3 != 0) {
                try {
                    queue.put("buzz");
                    current.incrementAndGet();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public void fizzbuzz() {
        while (true) {
            int num = current.get();
            if (num > n) break;
            if (num % 3 == 0 && num % 5 == 0) {
                try {
                    queue.put("fizzbuzz");
                    current.incrementAndGet();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public void number() {
        while (true) {
            int num = current.get();
            if (num > n) break;
            if (num % 3 != 0 && num % 5 != 0) {
                try {
                    queue.put(String.valueOf(num));
                    current.incrementAndGet();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public void printOutput() {
        StringBuilder result = new StringBuilder();
        while (true) {
            try {
                String output = queue.take();
                result.append(output).append(", ");
                if (current.get() > n && queue.isEmpty()) {
                    if (result.length() > 2) {
                        result.setLength(result.length() - 2);
                    }
                    System.out.println(result.toString());
                    break;
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
