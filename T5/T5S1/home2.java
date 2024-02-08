class home2 {
    public static void main(String[] args) {
        System.out.println("Простые числа от 1 до 1000: ");
        for (int i = 1; i <= 1000; i++) {
            if (core.isPrime(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}
