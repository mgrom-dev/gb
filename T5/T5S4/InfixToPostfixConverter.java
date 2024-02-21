import java.util.Stack;

/**
 * Реализовать алгоритм перевода из инфиксной записи в постфиксную для
 * арифметического выражения.
 * http://primat.org/news/obratnaja_polskaja_zapis/2016-04-09-1181
 * Вычислить запись если это возможно.
 */
public class InfixToPostfixConverter {
    public static String infixToPostfix(String expression) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char c : expression.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                result.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                return "Invalid expression";
            }
            result.append(stack.pop());
        }

        return result.toString();
    }

    private static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    public static int evaluatePostfixExpression(String expression) {
        Stack<Integer> stack = new Stack<>();

        for (char c : expression.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push(c - '0');
            } else {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result = applyOperator(operand1, operand2, c);
                stack.push(result);
            }
        }

        return stack.pop();
    }

    private static int applyOperator(int operand1, int operand2, char operator) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                if (operand2 == 0)
                    throw new ArithmeticException("Division by zero");
                return operand1 / operand2;
            case '^':
                return (int) Math.pow(operand1, operand2);
        }
        throw new IllegalArgumentException("Invalid operator: " + operator);
    }

    public static void main(String[] args) {
        String infix = "2+3*2";
        String postfix = infixToPostfix(infix);
        System.out.println("Infix Expression: " + infix);
        System.out.println("Postfix Expression: " + infixToPostfix(infix));
        System.out.println("Result: " + evaluatePostfixExpression(postfix));
    }
}
