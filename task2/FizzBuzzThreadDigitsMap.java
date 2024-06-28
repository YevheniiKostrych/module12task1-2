package module12.task2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class FizzBuzzThreadDigitsMap {
    private final int n;
    private final BlockingQueue<String> threadOueue = new LinkedBlockingQueue<>();

    public FizzBuzzThreadDigitsMap(int n) {
        this.n = n;
    }

    public void fizz(int i) {
        if (i % 3 == 0 && i % 5 != 0) {
            try {
                threadOueue.put("fizz");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void buzz(int i) {
            if (i % 3 != 0 && i % 5 == 0) {
                try {
                    threadOueue.put("buzz");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    }

    public void fizzbuzz(int i) {
            if (i % 3 == 0 && i % 5 == 0) {
                try {
                    threadOueue.put("fizzbuzz");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    }

    public void number(int i) {
            if (i % 3 != 0 && i % 5 != 0) {
                try {
                    threadOueue.put(String.valueOf(i));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
    }


    public void print() {
        for (int i = 1; i <= n; i++) {
            try {
                System.out.print(threadOueue.take());
                if (i < n) {
                    System.out.print(", ");
                } else {
                    System.out.print(".");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
