package book.chapter6;

public class Cookie2 {
    protected static void biteProtected() {
        System.out.println("bite protected cookie2");
    }

    static void biteDefault() {
        System.out.println("bite default cookie2");
    }

    @SuppressWarnings("unused")
    private static void bitePrivate() {
        System.out.println("bite private cookie2");
    }

    public static void bitePublic() {
        System.out.println("bite public cookie2");
    }
}
