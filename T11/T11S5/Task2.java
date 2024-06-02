/**
 * В рамках выполнения задачи необходимо:
 * Создайте два потока A и B.
 * Поток A меняет значение Boolean переменной switcher с задержкой 1000
 * миллисекунд
 * (true в состояние false и наоборот).
 * Поток B ожидает состояния true переменной switcher и выводит на консоль
 * обратный отсчет от 100
 * с задержкой 100 миллисекунд и приостанавливает свое действие, как только
 * поток A переключит switcher
 * в состояние false.
 * Условием завершения работы потоков является достижение отсчета нулевой
 * отметки.
 * Можно воспользоваться синхронизацией для управления значения переменной или
 * volatile
 */
public class Task2 {
    static int count = 100;
    /* если убрать volatile то переменная заблокируется чтением */
    volatile static boolean switcher = true;

    public static void main(String[] args) {
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                while (count > 0) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    switcher = !switcher;
                }
            }
        };
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                while (count > 0) {
                    if (switcher) {
                        count--;
                        System.out.println(count);
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    }
                }
        };
        thread1.start();
        thread2.start();
    }
}