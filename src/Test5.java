import java.util.Scanner;

public class Test5 {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("������� ��������� ");

            String input = scanner.nextLine();

            if (input.matches("^(10|[1-9]|IV|V|VI|VII|VIII|IX|X)\\s*[-+*/]\\s*(10|[1-9]|IV|V|VI|VII|VIII|IX|X)$")) {
                System.out.println("������ ������");
            } else {
                System.out.println("�������� ������");
            }

            scanner.close();
        }
    }

