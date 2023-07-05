import java.util.concurrent.atomic.AtomicInteger;

public class Task2 {
    public static AtomicInteger n = new AtomicInteger(1);
    public static int maxNumber = 30;

    public static void main(String[] args) {
        Thread threadA = new Thread(Task2::fizz);
        Thread threadB = new Thread(Task2::buzz);
        Thread threadC = new Thread(Task2::fizzbuzz);
        Thread threadD = new Thread(Task2::number);
        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();
    }

    private static void fizz() {
        while (n.get() < maxNumber) {
            sleep(5);
            if (n.get() % 3 == 0 && n.get() % 5 != 0) {
                System.out.println("fizz");
                n.incrementAndGet();
            }
        }
    }

    private static void buzz() {
        while (n.get() < maxNumber) {
            sleep(5);
            if (n.get() % 5 == 0 && n.get() % 3 != 0) {
                System.out.println("buzz");
                n.incrementAndGet();
            }
        }
    }

    private static void fizzbuzz() {
        while (n.get() < maxNumber) {
            sleep(5);
            if (n.get() % 15 == 0) {
                System.out.println("fizzbuzz");
                n.incrementAndGet();
            }
        }
    }

    private static void number() {
        while (n.get() < maxNumber) {
            sleep(5);
            if (n.get() % 3 != 0 && n.get() % 5 != 0) {
                System.out.println(n);
                n.incrementAndGet();
            }
        }
    }

    private static void sleep(int milliSec) {
        try {
            Thread.sleep(milliSec);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

