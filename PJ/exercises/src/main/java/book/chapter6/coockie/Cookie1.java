package book.chapter6.coockie;

public class Cookie1 {
    protected static void biteProtected() {
        System.out.println("bite protected cookie1");
    }

    static void biteDefault() {
        System.out.println("bite default cookie1");
    }

    @SuppressWarnings("unused")
    private static void bitePrivate() {
        System.out.println("bite private cookie1");
    }

    public static void bitePublic() {
        System.out.println("bite public cookie1");
    }
}
