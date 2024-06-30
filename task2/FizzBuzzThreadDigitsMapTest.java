package module12.task2;

public class FizzBuzzThreadDigitsMapTest {
    public static void main(String[] args) {
        int n = 15;
        FizzBuzzThreadDigitsMap fizzBuzzThreadDigitsMap=new FizzBuzzThreadDigitsMap(n);
            Thread threadA = new Thread(fizzBuzzThreadDigitsMap::fizz);
            Thread threadB = new Thread(fizzBuzzThreadDigitsMap::buzz);
            Thread threadC = new Thread(fizzBuzzThreadDigitsMap::fizzbuzz);
            Thread threadD = new Thread(fizzBuzzThreadDigitsMap::number);
            Thread printer = new Thread(fizzBuzzThreadDigitsMap::printOutput);
            threadA.start();
            threadB.start();
            threadC.start();
            threadD.start();
            printer.start();

            try {
                threadA.join();
                threadB.join();
                threadC.join();
                threadD.join();
                printer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
}

