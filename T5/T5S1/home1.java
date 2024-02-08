class home1 {
    public static void main(String[] args) {
        int n;
        String msg = "Введите целое число, больше 0: ";
        while ((n = core.readInteger(msg)) <= 0) ;
        System.out.printf("Треугольное число при n=%d, равно: %d\n", n, core.triangle(n));
        System.out.printf("Факториал числа %d, равен: %d\n", n, core.factorial(n));
    }
}
