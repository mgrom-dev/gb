package homework;

/**
 * Написать класс Калькулятор (необобщенный), который содержит обобщенные
 * статические методы: sum(), multiply(), divide(), subtract(). Параметры этих
 * методов – два числа разного типа, над которыми должна быть произведена
 * операция. Методы должны возвращать результат своей работы.
 */
public class Calculator {
    @SuppressWarnings("unchecked")
    public static <T extends Number, V extends Number> T sum(T a, V b) {
        return (T) (Double) Double.sum(a.doubleValue(), b.doubleValue());
    }

    @SuppressWarnings("unchecked")
    public static <T extends Number, V extends Number> T multiply(T a, V b) {
        return (T) (Double) (a.doubleValue() * b.doubleValue());
    }

    @SuppressWarnings("unchecked")
    public static <T extends Number, V extends Number> T divide(T a, V b) {
        return (T) (Double) (a.doubleValue() / b.doubleValue());
    }

    @SuppressWarnings("unchecked")
    public static <T extends Number, V extends Number> T subtract(T a, V b) {
        return (T) (Double) (a.doubleValue() - b.doubleValue());
    }

    public static void main(String[] args) {
        System.out.println("Tests sum, multiply, divide, subtract:");
        System.out.printf("sum(5 + 3.2f) = %.1f\n", sum(5, 3.2f));
        System.out.printf("sum(5 + 8) = %.0f\n", sum(5, 8));
        System.out.printf("multiply(2.5f * 2.8f) = %.1f\n", multiply(2.5f, 2.8f));
        System.out.printf("multiply(3 * 3) = %.0f\n", multiply(3, 3));
        System.out.printf("divide(5 / 10) = %.1f\n", divide(5, 10));
        System.out.printf("divide(6 / 2) = %.0f\n", divide(6, 2));
        System.out.printf("subtract(10 - 1.5f) = %.1f\n", subtract(10, 1.5f));
        System.out.printf("subtract(5 - 10) = %.0f\n", subtract(5, 10));
    }
}
