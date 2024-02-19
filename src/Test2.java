import java.util.Scanner;

public class Test2 {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("������� �������������� ���������: ");
            String expression = scanner.nextLine();

            if (checkExpression(expression)) {
                System.out.println("��������� ������� ���������");
            } else {
                System.out.println("��������� ������� �����������");
            }
        }

        public static boolean checkExpression(String expression) {
            // ��������� ����� ������
            if (expression.length() != 3) {
                return false;
            }

            // ���������, ��� ������ � ������ ������� �������� ������� �� 1 �� 10
            if (!Character.isDigit(expression.charAt(0)) || !Character.isDigit(expression.charAt(2))) {
                return false;
            }
            int num1 = Character.getNumericValue(expression.charAt(0));
            int num2 = Character.getNumericValue(expression.charAt(2));
            if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10) {
                return false;
            }

            // ���������, ��� ������ ������ �������� ����� �� �������������� ������
            char operator = expression.charAt(1);
            if (operator != '+' && operator != '-' && operator != '*' && operator != '/') {
                return false;
            }

            return true;
        }
}

