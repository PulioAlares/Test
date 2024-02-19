package ru.javabegin.oop;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("давай ");
        String s = scanner.nextLine();
        RomanToInteger rti = new RomanToInteger();
        int result = rti.romanToInt(s);
        System.out.println(result);
     }
}

class RomanToInteger {


    public int romanToInt(String s) {
        Map<Character, Integer>map = new HashMap<Character, Integer>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);

        int result = 0;
        int preValue = 0;

        for(int i = s.length()-1; i>=0;i--){
            int currValue = map.get(s.charAt(i));
            if (currValue >= preValue){
                result += currValue;
            } else {
                result -= currValue;
            }
            preValue = currValue;
        }
        return result;
    }

}





       /* public  checkString(String input) {
            if (input.matches("[1-9]|10[\\+\\-??][1-9]|10")) {
                System.out.println("верно");
            } else {
                System.out.println("хуй");
            }
        }*/

