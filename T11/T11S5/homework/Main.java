package homework;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 1. Пять безмолвных философов сидят вокруг круглого стола, перед каждым
 * философом стоит тарелка спагетти.
 * 2. Вилки лежат на столе между каждой парой ближайших философов.
 * 3. Каждый философ может либо есть, либо размышлять.
 * 4. Философ может есть только тогда, когда держит две вилки — взятую справа и
 * слева.
 * 5. Философ не может есть два раза подряд, не прервавшись на размышления
 * (можно не учитывать)
 * 
 * Описать в виде кода такую ситуацию. Каждый философ должен поесть три раза
 */

public class Main {
    private static final String[] counts = { "первый", "второй", "третий" };
    private static final String[] colors = {
            "\033[0m", "\033[031m", "\033[032m", "\033[033m", "\033[034m",
            "\033[035m"
    };

    private static class Philosoph extends Thread {
        private final int id;
        private final Fork leftFork;
        private final Fork rightFork;
        private final int eatingTimes = 3;

        public Philosoph(int id, Fork leftFork, Fork rightFork) {
            this.id = id;
            this.leftFork = leftFork;
            this.rightFork = rightFork;
        }

        private void think(int count) throws InterruptedException {
            System.out.printf("%sФилософ с id: %d думает %s раз.%s\n", colors[id + 1], id, counts[count], colors[0]);
            Thread.sleep((int) (Math.random() * 100));
        }

        private void eat(int count) throws InterruptedException {
            System.out.printf("%sФилософ с id: %d кушает %s раз.%s\n", colors[id + 1], id, counts[count], colors[0]);
            Thread.sleep((int) (Math.random() * 100));
            if (count == eatingTimes - 1)
                System.out.printf("%sФилософ с id: %d наелся.%s\n", colors[id + 1], id, colors[0]);
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < eatingTimes; i++) {
                    think(i);
                    synchronized (leftFork) {
                        leftFork.pickUp(this);
                        synchronized (rightFork) {
                            rightFork.pickUp(this);
                            eat(i);
                            rightFork.putDown(this);
                        }
                        leftFork.putDown(this);
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private static class Fork {
        private final int id;
        private final Lock lock = new ReentrantLock();

        public Fork(int id) {
            this.id = id;
        }

        public void pickUp(Philosoph philosoph) {
            lock.lock();
            System.out.printf("%sФилософ с id: %d взял %s%sвилку с id: %d%s\n",
                    colors[philosoph.id + 1], philosoph.id, colors[0], colors[id + 1], id, colors[0]);
        }

        public void putDown(Philosoph philosoph) {
            lock.unlock();
            System.out.printf("%sФилософ с id: %d опустил %s%sвилку с id: %d%s\n",
                    colors[philosoph.id + 1], philosoph.id, colors[0], colors[id + 1], id, colors[0]);
        }
    }

    public static void main(String[] args) {
        Philosoph[] philosophers = new Philosoph[5];
        Fork[] forks = new Fork[5];

        for (int i = 0; i < forks.length; i++)
            forks[i] = new Fork(i);

        /* Создаем философов и закрепляем для каждого левую и правую вилку */
        for (int i = 0; i < philosophers.length; i++) {
            Fork leftFork = forks[i];
            Fork rightFork = forks[(i + 1) % forks.length];
            philosophers[i] = new Philosoph(i, leftFork, rightFork);
            philosophers[i].start();
        }

        for (Philosoph philosopher : philosophers) {
            try {
                philosopher.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
