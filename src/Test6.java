import java.util.Scanner;

public class Test6 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("������� �������������� ��������� �������� ��� ��������� �������. ");
        String line = scanner.nextLine();
        System.out.println("���������: "+parse(line));
    }
    public static String parse (String line) throws Exception{
        int num1;
        int num2;
        String oper;
        String result;
        boolean isRoman;
        oper = detectOperation(line);
        if (oper == null) throw new Exception("���������������� �������������� �������� ");
        String[] operand = line.split("[+\\-*/]");
        if (operand.length != 2) throw new Exception("����� ���� ������ 2 ��������! ");

        if (Roman.isRoman(operand[0]) && Roman.isRoman(operand[1])){
            num1 = Roman.convertToArabian(operand[0]);
            num2 = Roman.convertToArabian(operand[1]);
            //System.out.println("������� �����");
            isRoman = true;
        }else if (!Roman.isRoman(operand[0]) && !Roman.isRoman(operand[1])){
            num1 = Integer.parseInt(operand[0]);
            num2 = Integer.parseInt(operand[1]);
           // System.out.println("�������� �����");
            isRoman = false;
        }else {
            throw new Exception("��������� ������ �������� ������ �� �������� ��� ������ �� ������� �����! ");
        }
        if (num1 > 10 || num2 > 10){
            throw new Exception("����� ������ ���� �� ������ 10! ");
        }else if (num1 == 0 || num2 == 0){
            throw new Exception("����� ������� ������ ������������� ����� �� 1 �� 10. ���� ������� ������! ");
        }
        int arabian = calc(num1,num2,oper);
        if (isRoman){
            if (arabian<=0){
                throw new Exception("������� ����� �� ����� ���� ������������� ��� ��������� ����! ");
            }
            result = Roman.convertToRoman(arabian);
        }else {
            result = String.valueOf(arabian);
        }
        return result;

    }

    static String detectOperation(String line) {
        if (line.contains("+")) return "+";
        else if (line.contains("-")) return "-";
        else if (line.contains("*")) return "*";
        else if (line.contains("/")) return "/";
        else return null;
    }
    static int calc(int a, int b, String oper){
        if (oper.equals("+")) return a+b;
        else if (oper.equals("-")) return a-b;
        else if (oper.equals("*")) return a*b;
        else return a/b;
    }
}
class Roman{
    static String[] romanArrey = new String[]{"O","I","II","III","IV","V","VI","VII","VIII","IX","X","XI","XII","XIII",
            "XIV","XV","XVI","XVII","XVIII","XIX","XX","XXI","XXII","XXIII","XXIV","XXV","XXVI","XXVII","XXVIII","XXIX",
            "XXX","XXXI","XXXII","XXXIII","XXXIV","XXXV","XXXVI","XXXVII","XXXVIII","XXXIX","XL","XLI","XLII","XLII",
            "XLIV","XLV","XLVI","XLVII","XLVIII","XLIX","L","LI","LII","LIII","LIV","LV","LVI","LVII","LVIII","LIX",
            "LX","LXI","LXII","LXIII","LXIV","LXV","LXVI","LXVII","LXVIII","LXIX","LXX","LXXI","LXXII","LXXIII","LXXIV"
            ,"LXXV","LXXVI","LXXVII","LXXVIII","LXXIX","LXXX","LXXXI","LXXXII","LXXXIII","LXXXIV","LXXXV","LXXXVI"
            ,"LXXXVII","LXXXVIII","LXXXIX","XC","XCI","XCII","XCIII","XCIV","XCV","XCVI","XCVII","XCVIII","XCIX","C",};


    public static boolean isRoman(String val){
        for (int i = 0; i < romanArrey.length; i++){
            if(val.equals(romanArrey[i]))
            return true;
        }
        return false;
    }
    public static int convertToArabian(String roman){
        for (int i = 0; i < romanArrey.length; i++){
            if (roman.equals(romanArrey[i])){
                return i;
            }
        }
        return -1;
    }
    public static String convertToRoman(int arabian){return romanArrey[arabian];}
}
