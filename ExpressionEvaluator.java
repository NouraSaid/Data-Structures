import java.util.Stack;

public class ExpressionEvaluator {

    public static void main(String[] args) {
        // Example usage:
        String expression = "3 + 5 * ( 2 - 4 ) / 2";
        double result = evaluateExpression(expression);
        System.out.println("Result: " + result);
    }

    public static double evaluateExpression(String expression) {
        Stack<Double> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (Character.isDigit(ch)) {
                // If the current character is a digit, extract the whole number and push it to the numbers stack
                StringBuilder numStr = new StringBuilder();
                while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    numStr.append(expression.charAt(i));
                    i++;
                }
                i--; // Adjust the index back since it has moved one step ahead
                numbers.push(Double.parseDouble(numStr.toString()));
            } else if (ch == '(') {
                // Push opening parenthesis onto the operators stack
                operators.push(ch);
            } else if (ch == ')') {
                // Evaluate the expression inside the parentheses
                while (!operators.isEmpty() && operators.peek() != '(') {
                    applyOperator(numbers, operators);
                }
                operators.pop(); // Pop the opening parenthesis
            } else if (isOperator(ch)) {
                // Process operators
                while (!operators.isEmpty() && hasPrecedence(ch, operators.peek())) {
                    applyOperator(numbers, operators);
                }
                operators.push(ch);
            }
        }

        // Process remaining operators
        while (!operators.isEmpty()) {
            applyOperator(numbers, operators);
        }

        // The final result is on the top of the numbers stack
        return numbers.pop();
    }

    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    private static boolean hasPrecedence(char op1, char op2) {
        return (op2 == '(' || op2 == ')') || (op1 != '*' && op1 != '/' && (op2 == '+' || op2 == '-'));
    }

    private static void applyOperator(Stack<Double> numbers, Stack<Character> operators) {
        char operator = operators.pop();
        double operand2 = numbers.pop();
        double operand1 = numbers.pop();

        switch (operator) {
            case '+':
                numbers.push(operand1 + operand2);
                break;
            case '-':
                numbers.push(operand1 - operand2);
                break;
            case '*':
                numbers.push(operand1 * operand2);
                break;
            case '/':
                numbers.push(operand1 / operand2);
                break;
        }
    }
}