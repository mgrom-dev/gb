package book.chapter2;

/**
 * �������� �� �� ��� ���� � �������������� ������ DataOnly.
 * �������� ���������� 4 ���, ����� ������ ������ DataOnly �������������
 * ��������, � ����� ������������ �� � ������ main()
 */
public class DataOnly {
    int i;
    double d;
    boolean b;

    public static void main(String[] args) {
        DataOnly data = new DataOnly();
        data.i = 47;
        data.d = 1.1;
        data.b = false;
        System.out.printf("%d %f %s\n", data.i, data.d, data.b);
    }
}
