/**
 * Написать функцию добавления элемента в конец массива таким
 * образом, чтобы она расширяла массив при необходимости.
 */
public class Task4 {
    int[] array;
    
    Task4(int[] array) {
        this.array = array;
    }

    Task4() {
        this.array = new int[0];
    }

    public static void main(String[] args) {
        Task4 t = new Task4();
        t.add(1);
        t.add(2);
        t.add(1, 0);
        System.out.println(t);
    }

    public void add(int value) {
        int[] newArray = new int[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        newArray[array.length] = value;
        array = newArray;
    }

    public void add(int index, int value) {
        if (index < 0 || index > array.length) {
            throw new IndexOutOfBoundsException();
        }
        int[] newArray = new int[array.length + 1];
        for (int i = 0; i < index; i++) {
            newArray[i] = array[i];
        }
        newArray[index] = value;
        for (int i = index; i < array.length; i++) {
            newArray[i + 1] = array[i];
        }
        array = newArray;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(array[i]);
        }
        sb.append("]\n");
        return sb.toString();
    }
}
