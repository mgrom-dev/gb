public class Test {
    public static void main(String[] args) {
        System.out.println();
        double x = 1.5;
        double y = 2.65;
        System.out.println((int)x + (int)y);
    }

    static int fact(
            int num) {
        int res = 1;
        for (int x = 1; x <= num; x++) {
            res *= x;
        }

        return res;
    }
}