/**
 * ���������� ��������� ���� � ������� lncrementable � ���������� ���������.
 * �������� ���������, ������� �������������, ��� ���������� �� ����������
 * ��������� �������� ����� �������� ������ ���� ��������� ���� static.
 */
public class Incrementable {
    static class StaticTest {
        static int i = 47;
    }

    static void increment() {
        StaticTest.i++;
    }

    @SuppressWarnings("static-access")
    public static void main(String[] args) {
        StaticTest st1 = new StaticTest(); // ������� 2 ���������� ������
        StaticTest st2 = new StaticTest(); // ����������� ���� i ���������� ������ � 1 ����������
        StaticTest.i++; // �������������� �������� i
        System.out.printf("st1.i: %d, st2.i: %d\n", st1.i, st2.i); // �������� i ���������� 48
        Incrementable sf = new Incrementable(); // ������� ����� �����
        sf.increment(); // ��� ��������� ����� ��������� ������, ����� ������ ���� � ��� �� �����
        Incrementable.increment(); // ����������� �����
        System.out.printf("st1.i: %d, st2.i: %d\n", st1.i, st2.i); // 50
    }
}
