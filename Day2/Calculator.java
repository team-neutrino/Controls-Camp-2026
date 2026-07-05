package Day2;

public class Calculator {
    private double m_num1;
    private double m_num2;
    private char m_operator;

    public Calculator(double p_num1, double p_num2, char p_operator) {
        m_num1 = p_num1;
        m_num2 = p_num2;
        m_operator = p_operator;
    }

    public double calculate() {
        if (m_operator == '+') {
            return m_num1 + m_num2;
        } else if (m_operator == '-') {
            return m_num1 - m_num2;
        } else if (m_operator == '*') {
            return m_num1 * m_num2;
        } else if (m_operator == '/') {
            return m_num1 / m_num2;
        } else {
            System.out.println("Invalid Operator");
            return 0.0;
        }
    }

    public static void main(String[] args) {
        Calculator calc1 = new Calculator(4, 2, '+');
        System.out.println("Result: " + calc1.calculate()); // Expected: 6.0

        Calculator calc2 = new Calculator(10, 2, '/');
        System.out.println("Result: " + calc2.calculate()); // Expected: 5.0

        Calculator calc3 = new Calculator(7, 3, '*');
        System.out.println("Result: " + calc3.calculate()); // Expected: 21

        Calculator calc4 = new Calculator(5, 5, '-');
        System.out.println("Result: " + calc4.calculate()); // Expected: 0
    }

}
