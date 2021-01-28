package Qursed;

import java.util.IllegalFormatException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int answer;
        System.out.print("Введите выражение: ");
        Scanner scanner = new Scanner(System.in);
        String[] expression = (scanner.nextLine()).split(" ");
        try {
            if (expression.length != 3) {
                throw new Exception();
            }
        } catch (Exception ex) {
            System.out.println("Выражение введено неверно.");
        }
        int a = Converter.getArab(expression[0]);
        int b = Converter.getArab(expression[2]);
        int a1 = Converter.getRome(expression[0]);
        int b1 = Converter.getRome(expression[2]);
        if (a > 0 && b > 0) {
            System.out.println(Calculator.calculator(a, b, expression[1]));
        } else if (a1 > 0 && b1 > 0) {
            System.out.println(Converter.arabToRoman(Calculator.calculator(a1, b1, expression[1])));
        } else {
            throw new IllegalArgumentException("Неверный формат чисел");
        }

    }

    static class Converter {
        private static final String[] arab = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        private static final String[] rome = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};

        public static int getArab(String number) {
            int result = 0;
            for (int i = 0; i < arab.length; i++) {
                if (number.equals(arab[i])) {
                    result = i + 1;
                }
            }
            return result;
        }

        public static int getRome(String number){
            int result = 0;
            for (int i = 0; i < rome.length; i++) {
                if (number.equals(rome[i])) {
                    result = i + 1;
                }
            }
            return result;
        }

        public static String arabToRoman(int input){
            if (input < 1)
                throw new IllegalArgumentException("Римское число должно быть больше нуля.");
            String s = "";
            while (input >= 100) {
                s += "C";
                input -= 100;
            }
            while (input >= 90) {
                s += "XC";
                input -= 90;
            }
            while (input >= 50) {
                s += "L";
                input -= 50;
            }
            while (input >= 40) {
                s += "XL";
                input -= 40;
            }
            while (input >= 10) {
                s += "X";
                input -= 10;
            }
            while (input >= 9) {
                s += "IX";
                input -= 9;
            }
            while (input >= 5) {
                s += "V";
                input -= 5;
            }
            while (input >= 4) {
                s += "IV";
                input -= 4;
            }
            while (input >= 1) {
                s += "I";
                input -= 1;
            }
            return s;
        }

    }

    static class Calculator {
        public static int calculator(int num1, int num2, String oper) {
            int result;
            switch (oper) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    result = num1 / num2;
                    break;
                default:
                    throw new IllegalArgumentException("Неверный знак операции");

            }
            return result;
        }
    }
}
