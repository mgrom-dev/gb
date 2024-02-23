import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * �������� ���������, ������������ ������������ ����������� ������ � ���������.
 * ������ 1: a+(d*3) - ������
 * ������ 2: [a+(1*3) - ����
 * ������ 3: [6+(3*3)] - ������
 * ������ 4: {a}[+]{(d*3)} - ������
 * ������ 5: <{a}+{(d*3)}> - ������
 * ������ 6: {a+]}{(d*3)} - ����
 */
public class Brackets {
    public static void main(String[] args) {
        String[] strings = { "a+(d*3)", "[a+(1*3)", "[6+(3*3)]", "{a}[+]{(d*3)}", "<{a}+{(d*3)}>", "{a+]}{(d*3)}" };
        for (String str : strings) {
            System.out.println(checkBrackets(str));
        }
    }

    public static boolean checkBrackets(String expression) {
        Map<Character, Character> brackets = getBrackets();
        Stack<Character> stack = new Stack<>();
        for (char symbol : expression.toCharArray()) {
            if (brackets.containsValue(symbol))
                stack.push(symbol);
            else if (brackets.containsKey(symbol))
                if (stack.isEmpty() || stack.pop() != brackets.get(symbol))
                    return false;
        }
        return stack.isEmpty();
    }

    public static Map<Character, Character> getBrackets() {
        Map<Character, Character> brackets = new HashMap<>();
        brackets.put(')', '(');
        brackets.put(']', '[');
        brackets.put('}', '{');
        brackets.put('>', '<');
        return brackets;
    }
}
