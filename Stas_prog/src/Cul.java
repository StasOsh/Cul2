import java.util.InputMismatchException;
import java.util.Scanner;


public class Cul {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Arabian a = new Arabian();
        Rim b = new Rim();

        if (scanner.hasNextInt()) {
            a.arabian();
        } else if (scanner.hasNextLine()) {
            b.rimca();
        }else if(scanner.hasNextLine()){
            System.out.println("строка не является математической операцией");
            System.exit(0);}
    }

    public static class Arabian {
        public void arabian() {
            int num1 = getInt();
            char operation = getOperation();
            int num2 = getInt();
            int rezult1 = calc(num1, num2, operation);
            System.out.println(rezult1);
        }
    }

    public static class Rim {
        public void rimca() {
            String s;
            int num3 = rim();

            char operation2 = getOperation();

            int num4 = rim();

            int rezult2 = calc(num3, num4, operation2);

            s = convertNumToRoman(rezult2);
            System.out.println(s);
        }
    }

    public static int rim() {
        int i;
        i = romanToNumber(scanner.next());
        return i;
    }

    public static int getInt() {
        int num;
        if (scanner.hasNextInt()) {
            num = scanner.nextInt();
            if (Math.abs(num) > 10) {
                System.out.println("модуль числа должен быть небольше 10");
            }
            return num;
        } else {
            System.out.println("Вы допустили ошибку при вводе числа.");
            System.exit(0);
        }
        return 0;
    }

    private static String convertNumToRoman(int numArabian) {
        if(numArabian>0){
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };

            final String s = roman[numArabian];

            return s;}
        else{
            System.out.println("в римской системе нет отрицательных чисел");
            System.exit(0);
        }

        return null;
    }

    private static int romanToNumber(String roman) {
        try {
            if (roman.equals("I")) {
                return 1;
            } else if (roman.equals("II")) {
                return 2;
            } else if (roman.equals("III")) {
                return 3;
            } else if (roman.equals("IV")) {
                return 4;
            } else if (roman.equals("V")) {
                return 5;
            } else if (roman.equals("VI")) {
                return 6;
            } else if (roman.equals("VII")) {
                return 7;
            } else if (roman.equals("VIII")) {
                return 8;
            } else if (roman.equals("IX")) {
                return 9;
            } else if (roman.equals("X")) {
                return 10;
            }
        } catch (InputMismatchException e) {
        }
        System.out.println("используются одновременно разные системы счисления");
        System.exit(0);
        return 0;
    }


    public static char getOperation() {
        char operation;
        if (scanner.hasNext()) {
            operation = scanner.next().charAt(0);
        } else {
            System.out.println("вы допустили ошибку при вводе операции");
            scanner.next();
            operation = getOperation();
        }
        return operation;
    }

    public static int calc(int num1, int num2, char operation) {
        int result;
        switch (operation) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            default:
                System.out.println("Операция не распознана. Повторите ввод.");
                result = calc(num1, num2, getOperation());
        }
        return result;
    }
}
