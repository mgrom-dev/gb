/**
 * В рамках выполнения задачи необходимо:
 * Создать два класс ObjectA, ObjectB
 * Реализовать класс в котором два потока при запуске провоцируют DeadLock для
 * объектов ObjectA, ObjectB
 */
public class Task1 {
    static class ObjectA extends Thread {
        @Override
        public void start() {
            synchronized (ObjectA.class) {
                synchronized (ObjectB.class) {
                    System.out.println("DeadLock 1");
                }
            }
        }
    }

    static class ObjectB extends Thread {
        @Override
        public void start() {
            synchronized (ObjectB.class) {
                synchronized (ObjectA.class) {
                    System.out.println("DeadLock 2");
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Object objA = new Object();
        Object objB = new Object();
        Thread threadA = new Thread(){
            @Override
            public void run() {
                synchronized (objA) {
                    synchronized (objB) {
                        System.out.println("DeadLock 1");
                    }
                }
            }
        };
        Thread threadB = new Thread(){
            @Override
            public void run() {
                synchronized (objB) {
                    synchronized (objA) {
                        System.out.println("DeadLock 2");
                    }
                }
            }
        };
        threadA.start();
        threadB.start();
    }
}