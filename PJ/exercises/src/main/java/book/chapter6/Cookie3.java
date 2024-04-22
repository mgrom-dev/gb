package book.chapter6;

public class Cookie3 extends book.chapter6.coockie.Cookie1 {
    public static void bite() {
        // приватный метод не доступен
        // bitePrivate(); 
        // как и метод с доступом по умолчанию
        // biteDefault();
        biteProtected();
        bitePublic();
    }
}
