import java.util.Scanner;

public class Test4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

            if (containsTwoNumbersAndSymbol(str)) {
                System.out.println("Строка содержит два числа, разделенных одним из символов (-, +, *, /)");
            } else {
                System.out.println("Строка НЕ содержит два числа, разделенных одним из символов (-, +, *, /)");
            }
        }

        private static boolean containsTwoNumbersAndSymbol(String str) {
            boolean containsFirstNumber = true;
            boolean containsSecondNumber = false;
            boolean containsSymbol = false;

            // Пройдемся по символам в строке
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                // Проверяем первое число
                if (Character.isDigit(c) && !containsFirstNumber) {
                    containsFirstNumber = true;
                    // Пропустим цифры первого числа
                    while (Character.isDigit(str.charAt(i))) {
                        i++;
                    }
                }

                // Проверяем символ разделения
                if (containsFirstNumber && !containsSymbol && (c == '-' || c == '+' || c == '*' || c == '/')) {
                    containsSymbol = true;
                }

                // Проверяем второе число
                if (containsFirstNumber && containsSymbol && Character.isDigit(c) && !containsSecondNumber) {
                    containsSecondNumber = true;
                    // Пропустим цифры второго числа
                    while (i < str.length() && Character.isDigit(str.charAt(i))) {
                        i++;
                    }
                }
            }

            // Возвращаем true, если оба числа и разделитель найдены
            return containsFirstNumber && containsSecondNumber && containsSymbol;
        }
    }

