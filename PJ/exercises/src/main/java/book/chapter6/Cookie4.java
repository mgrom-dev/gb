package book.chapter6;

public class Cookie4 extends Cookie2 {
    public static void bite() {
        // приватный метод не доступен
        // bitePrivate();
        biteDefault();
        biteProtected();
        bitePublic();
    }
}
