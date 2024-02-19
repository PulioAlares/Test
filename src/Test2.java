import java.util.Scanner;

public class Test2 {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Введите математическое выражение: ");
            String expression = scanner.nextLine();

            if (checkExpression(expression)) {
                System.out.println("Выражение введено корректно");
            } else {
                System.out.println("Выражение введено некорректно");
            }
        }

        public static boolean checkExpression(String expression) {
            // Проверяем длину строки
            if (expression.length() != 3) {
                return false;
            }

            // Проверяем, что первый и третий символы являются цифрами от 1 до 10
            if (!Character.isDigit(expression.charAt(0)) || !Character.isDigit(expression.charAt(2))) {
                return false;
            }
            int num1 = Character.getNumericValue(expression.charAt(0));
            int num2 = Character.getNumericValue(expression.charAt(2));
            if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10) {
                return false;
            }

            // Проверяем, что второй символ является одним из математических знаков
            char operator = expression.charAt(1);
            if (operator != '+' && operator != '-' && operator != '*' && operator != '/') {
                return false;
            }

            return true;
        }
}

