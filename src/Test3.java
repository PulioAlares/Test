import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test3 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Введите выражение: ");
            String input = scanner.nextLine();
            System.out.println("1");
            System.out.println(input.length());
                String[] parts = input.split("[-+*/]");
            System.out.println("2");
                if (parts.length >= 9) {
                    throw new IllegalArgumentException("Неверный формат выражения");
                }
            System.out.println("3");
                String num1 = parts[0];
                String operator = parts[1];
                String num2 = parts[2];
            System.out.println(num1+num2+operator);
                if ((!isArabicNumber(num1) && !isRomanNumber(num1)) || (!isArabicNumber(num2) && !isRomanNumber(num2))) {
                    throw new IllegalArgumentException("Введены цифры разных типов");
                }
            System.out.println("4");
                int operand1 = convertToArabic(num1);
                int operand2 = convertToArabic(num2);
            System.out.println("5");
                if ((operand1 < 1 || operand1 > 10) || (operand2 < 1 || operand2 > 10)) {
                    throw new IllegalArgumentException("Числа должны быть от 1 до 10");
                }

                int result = performOperation(operand1, operand2, operator);
            System.out.println("6");
                if (isArabicNumber(parts[0])) {
                    System.out.println("Результат: " + result);
                } else {
                    System.out.println("Результат: " + convertToRoman(result));
                }

        }

        public static boolean isArabicNumber(String input) {
            return input.matches("[1-9]|10");
        }

        public static boolean isRomanNumber(String input) {
            return input.matches("^(?=[MDCLXVI])M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
        }

        public static int convertToArabic(String romanNumber) {
            Map<Character, Integer> romanMap = new HashMap<Character, Integer>();
            romanMap.put('I', 1);
            romanMap.put('V', 5);
            romanMap.put('X', 10);
            romanMap.put('L', 50);
            romanMap.put('C', 100);
            romanMap.put('D', 500);
            romanMap.put('M', 1000);

            int arabicNumber = 0;
            int prevValue = 0;

            for (int i = romanNumber.length() - 1; i >= 0; i--) {
                int value = romanMap.get(romanNumber.charAt(i));
                if (value < prevValue) {
                    arabicNumber -= value;
                } else {
                    arabicNumber += value;
                }
                prevValue = value;
            }

            return arabicNumber;
        }

        public static String convertToRoman(int number) {
            if (number < 1) {
                throw new IllegalArgumentException("Римские числа не могут быть меньше 1");
            }

            if (number == 0) {
                return "N";
            }

            String[] romanNumerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
            int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

            StringBuilder romanNumber = new StringBuilder();

            for (int i = 0; i < values.length; i++) {
                while (number >= values[i]) {
                    number -= values[i];
                    romanNumber.append(romanNumerals[i]);
                }
            }

            return romanNumber.toString();
        }

        public static int performOperation(int num1, int num2, String operator) {
            if ("+".equals(operator)) {
                return num1 + num2;
            } else if ("-".equals(operator)) {
                return num1 - num2;
            } else if ("*".equals(operator)) {
                return num1 * num2;
            } else if ("/".equals(operator)) {
                return num1 / num2;
            }
            throw new IllegalArgumentException("Неверный оператор");
        }
    public char getOperation(String line) {
        char plus = 0;
        if (line.contains("+")) {
            plus = '+';
            // System.out.println(plus);
        }else if (line.contains("-")){
            plus = '-';
            // System.out.println(plus);
        }else if (line.contains("*")){
            plus = '*';
            // System.out.println(plus);
        }else if (line.contains("/")){
            plus = '/';
            // System.out.println(plus);
        }
        return plus;
    }
}

