import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * В рамках выполнения задачи необходимо:
 * 3 бегуна должны прийти к старту гонки
 * Программа должна гарантировать, что гонка начнется только когда все три
 * участника будут на старте
 * Программа должна отсчитать “На старт”, “Внимание”, “Марш”
 * Программа должна завершиться когда все участники закончат гонку.
 * Подумайте об использовании примитива синхронизации
 */
public class Task3 {
    private static class Runner extends Thread {
        private final String name;
        private static Random random = new Random();
        private CountDownLatch cdl;

        Runner(String name, CountDownLatch cdl) {
            this.name = name;
            this.cdl = cdl;
        }

        @Override
        public void run() {
            try {
                goToStart();
                cdl.await();
                synchronized (this) {
                    wait();
                }
                goToFinish();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        public void go() {
            synchronized (this) {
                notify();
            }
        }

        public void goToStart() throws InterruptedException {
            System.out.println(name + " движется к линии старта");
            sleep(1000 + random.nextLong(2000));
            System.out.println(name + " на старте");
            cdl.countDown();
        }

        public void goToFinish() throws InterruptedException {
            System.out.println(name + " бежит к линии финиша");
            sleep(1000 + random.nextLong(3000));
            System.out.println(name + " финишировал");
        }
    }

    public static void main(String[] args) {
        CountDownLatch cdl = new CountDownLatch(3);
        Runner runner = new Runner("Вася", cdl);
        Runner runner2 = new Runner("Петя", cdl);
        Runner runner3 = new Runner("Коля", cdl);
        runner.start();
        runner2.start();
        runner3.start();

        try {
            cdl.await();
            gogogo();
            runner.go();
            runner2.go();
            runner3.go();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static void gogogo() {
        try {
            System.out.println("На старт!");
            Thread.sleep(100);
            System.out.println("Внимание!");
            Thread.sleep(100);
            System.out.println("Марш!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
