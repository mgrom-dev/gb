/**
 * Обработайте возможные исключительные ситуации. “Битые” значения в исходном
 * массиве считайте нулями. Можно внести в код правки, которые считаете
 * необходимыми.
 */

 public class Task2 {
    public static void main(String[] args) {
        String [][] array = {
                {"3O", "41", "55", "69", "23"},
                {"88", "46", "55", null, "23"},
                null,
                {"39", "04", "50", "06"}};
        System.out.println(sum2d(array));
    }
    public static int sum2d (String[][] arr) {
        if (arr == null) {
            throw new RuntimeException("Не инициализированный массив");
        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++){
                try {
                    int val = Integer.parseInt(arr[i][j]);
                    sum += val;

                } catch (NumberFormatException e ){
                    System.out.printf("Элемент [%s][%s] битый \n", i, j);
                }


            }
        }
        return sum;
    }
}