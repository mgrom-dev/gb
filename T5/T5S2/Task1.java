/**
 * Дано четное число N (>0) и символы c1 и c2. Написать метод, который вернет
 * строку длины N, которая состоит из чередующихся символов c1 и c2, начиная с
 * c1.
 */
public class Task1 {
    public static void main(String[] args) {
        int N = 20;
        char c1 = 'C';
        char c2 = 'X';
        System.out.println(repeat2Char(N, c1, c2));
    }

    public static String repeat2Char(int N, char c1, char c2) {
        StringBuilder sb = new StringBuilder(N);
        while(sb.length() < N)
            sb.append(c1).append(c2);
        return sb.toString();
    }
}