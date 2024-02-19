import java.util.Scanner;

public class Test4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

            if (containsTwoNumbersAndSymbol(str)) {
                System.out.println("������ �������� ��� �����, ����������� ����� �� �������� (-, +, *, /)");
            } else {
                System.out.println("������ �� �������� ��� �����, ����������� ����� �� �������� (-, +, *, /)");
            }
        }

        private static boolean containsTwoNumbersAndSymbol(String str) {
            boolean containsFirstNumber = true;
            boolean containsSecondNumber = false;
            boolean containsSymbol = false;

            // ��������� �� �������� � ������
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                // ��������� ������ �����
                if (Character.isDigit(c) && !containsFirstNumber) {
                    containsFirstNumber = true;
                    // ��������� ����� ������� �����
                    while (Character.isDigit(str.charAt(i))) {
                        i++;
                    }
                }

                // ��������� ������ ����������
                if (containsFirstNumber && !containsSymbol && (c == '-' || c == '+' || c == '*' || c == '/')) {
                    containsSymbol = true;
                }

                // ��������� ������ �����
                if (containsFirstNumber && containsSymbol && Character.isDigit(c) && !containsSecondNumber) {
                    containsSecondNumber = true;
                    // ��������� ����� ������� �����
                    while (i < str.length() && Character.isDigit(str.charAt(i))) {
                        i++;
                    }
                }
            }

            // ���������� true, ���� ��� ����� � ����������� �������
            return containsFirstNumber && containsSecondNumber && containsSymbol;
        }
    }

