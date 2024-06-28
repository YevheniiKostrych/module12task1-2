package module12.task2;

public class FizzBuzzThreadDigitsMapTest {
    public static void main(String[] args) {
        int n = 15;
        FizzBuzzThreadDigitsMap fizzBuzzThreadDigitsMap = new FizzBuzzThreadDigitsMap(n);
        for (int i = 1; i <= n; i++) {
            final int current = i;
            Thread threadA = new Thread(() -> fizzBuzzThreadDigitsMap.fizz(current));
            Thread threadB = new Thread(() -> fizzBuzzThreadDigitsMap.buzz(current));
            Thread threadC = new Thread(() -> fizzBuzzThreadDigitsMap.fizzbuzz(current));
            Thread threadD = new Thread(() -> fizzBuzzThreadDigitsMap.number(current));
            threadA.start();
            threadB.start();
            threadC.start();
            threadD.start();

            try {
                threadA.join();
                threadB.join();
                threadC.join();
                threadD.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        fizzBuzzThreadDigitsMap.print();
    }
}

