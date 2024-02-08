public class task6 {
    public static void main(String[] args) {
        int a1 = 3, b1 = 2;
        int a2 = 2, b2 = -2;
        int a3 = 3, b3 = 0;
        System.out.println("Ответ 1: " + power(a1, b1));
        System.out.println("Ответ 2: " + power(a2, b2));
        System.out.println("Ответ 3: " + power(a3, b3));
        System.out.println("Ответ 1: " + powRec(a1, b1));
        System.out.println("Ответ 2: " + powRec(a2, b2));
        System.out.println("Ответ 3: " + powRec(a3, b3));
        System.out.println("Ответ 1: " + powIter(a1, b1));
        System.out.println("Ответ 2: " + powIter(a2, b2));
        System.out.println("Ответ 3: " + powIter(a3, b3));
    }

    // рекурсивное решение из презентации
    public static double powRec(double a, double b) {
        if (b == 0)
            return 1;
        if (b < 0)
            return powRec(1 / a, -b);
        double res = powRec(a, b / 2);
        return b % 2 == 0 ? res * res : res * res * a;
    }

    // итеративное решение из презентации
    public static double powIter(double a, double b) {
        if (a == 0 || a == 1)
            return a;
        if (b == 0)
            return 1;
        if (b < 0) {
            b = -b;
            a = 1 / a;
        }
        double result = 1;
        while (b > 0) {
            if (b % 2 == 1)
                result = result * a;
            a = a * a;
            b = b / 2;
        }
        return result;
    }

    // мое решение
    public static double power(int a, int b) {
        if (b >= 0) {
            return positivePower(a, b);
        } else {
            return 1.0 / positivePower(a, -b);
        }
    }

    // мое решение
    private static double positivePower(int a, int b) {
        if (b == 0) {
            return 1;
        }
        double half = positivePower(a, b / 2);
        if (b % 2 == 0) {
            return half * half;
        } else {
            return a * half * half;
        }
    }
}
