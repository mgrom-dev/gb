import java.util.HashMap;

/**
 * �� ��������� � ����������� ��� ����� ���� �������������. ���� ������ -
 * ����������� ���������, ������� ��������� �� ���� ���� ���� ������������� (���
 * ���������� ����� �� ���������, ���� ��������� �� �������������) �
 * ������������, ������� ��� ������ ��� �����������.
 * ��������� ������ ������������ HashMap ��� �������� ���� � �� ����������
 * ���������.
 * �� ����������, ��������� ������� ��������� � ���� ��� "��� - ����������".
 * �� �����:
 * 'Elena'
 * 'Elena'
 * 'Elena'
 * 'Ivan'
 * 'Ivan'
 * �� ������:
 * {Ivan=2, Elena=3}
 */
public class NamesCounterH {
    public static void main(String[] args) {
        String name1;
        String name2;
        String name3;
        String name4;
        String name5;

        if (args.length == 0) {
            name1 = "Elena";
            name2 = "Elena";
            name3 = "Elena";
            name4 = "Elena";
            name5 = "Ivan";
        } else {
            name1 = args[0];
            name2 = args[1];
            name3 = args[2];
            name4 = args[3];
            name5 = args[4];
        }
        NamesCounter namesCounter = new NamesCounter();

        namesCounter.addName(name1);
        namesCounter.addName(name2);
        namesCounter.addName(name3);
        namesCounter.addName(name4);

        namesCounter.addName(name5);

        namesCounter.showNamesOccurrences();
    }
}

class NamesCounter {
    private HashMap<String, Integer> names = new HashMap<>();

    public void addName(String name) {
        names.put(name, names.getOrDefault(name, 0) + 1);
    }

    public void showNamesOccurrences() {
        System.out.println(names);
    }
}