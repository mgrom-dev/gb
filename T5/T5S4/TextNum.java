import java.util.Arrays;
import java.util.LinkedList;

/**
 * ����������� ���������� ����������, �������:
 * 1. ��������� �� ������������ ������ ����
 * text~num
 * 2. ����� ����������� ������ �� ~, ��������� text � ������� ������ ��
 * ������� num.
 * 3. ���� ������� print~num, ������� ������ �� ������� num � �������
 * ������ � ������� � �� ������.
 */
public class TextNum {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        System.out.println(Arrays.toString(args));
        for (String param : args) {
            String[] params = param.split("~");
            if (params.length == 2) {
                int index = Integer.parseInt(params[1]);
                if (params[0].equals("print"))
                    System.out.println(list.remove(index > list.size() ? list.size() : index));
                else
                    list.add(index > list.size() ? list.size() : index, params[0]);
            }
        }
    }
}
