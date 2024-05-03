import java.util.Arrays;

/**
 * Написать метод, которому можно передать в качестве аргумента массив,
 * состоящий строго из единиц и нулей (целые числа типа int). Метод должен
 * заменить единицы в массиве на нули, а нули на единицы и не содержать
 * ветвлений. Написать как можно больше вариантов метода
 */
public class Change {
    public static void main(String[] args) {
        int[] arr = {1, 1, 0, 0, 1, 1};
        System.out.println(Arrays.toString(arr));
        change(arr);
        System.out.println(Arrays.toString(arr));
        change(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void change(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            //arr[i] = 1 - arr[i];
            arr[i] ^= 1;
            // arr[i] = (arr[i] - 1) * -1;
            // arr[i] = (arr[i] + 1) % 2;
        }
    }
}
