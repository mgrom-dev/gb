/**
 * StringTest
 */
public class StringTest {
    public static void main(String[] args) {
        // на компьютере преподавателя код со String занял 42с выполнения
        //String str = "";
        long start = System.currentTimeMillis();

        /*
        for (int i = 0; i < 1_000_000; i++)
            str += "+";
        */

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1_000_000; i++) {
            sb.append("+");
        }
            
        System.out.println(sb.length());
        
        long finish = System.currentTimeMillis();
        long elapsed = (finish - start) / 1_000;
        System.out.println("Время выполнения: " + elapsed + " мс");
    }
}