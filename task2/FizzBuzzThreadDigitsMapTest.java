package module12.task2;
public class FizzBuzzThreadDigitsMapTest {
    public static void main(String[] args) {
        int n = 15;
        FizzBuzzThreadDigitsMap fizzBuzzThreadDigitsMap=new FizzBuzzThreadDigitsMap(n);
            Thread threadA = new Thread(fizzBuzzThreadDigitsMap::fizz);
            Thread threadB = new Thread(fizzBuzzThreadDigitsMap::buzz);
            Thread threadC = new Thread(fizzBuzzThreadDigitsMap::fizzbuzz);
            Thread threadD = new Thread(fizzBuzzThreadDigitsMap::number);

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
                Thread.currentThread().interrupt();
            }
        }
}

