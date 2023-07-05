import java.util.concurrent.atomic.AtomicInteger;

public class Task1 {
    public static void main(String[] args) {

        Thread thread1 = new Thread(Task1::runForFirstThread);
        Thread thread2 = new Thread(Task1::runForSecondThread);
        thread1.start();
        thread2.start();
    }

    private static void runForFirstThread() {
        int counter = 0;
        while (true) {
            System.out.print("\r");
            System.out.print(++counter);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void runForSecondThread() {
        while (true) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.print("\r");
            System.out.println("It has passed 5 seconds");
        }
    }
}
