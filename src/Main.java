import java.util.Scanner;
public class Main {
    static boolean rezultatrim1 = false;
    static boolean rezultatrim2 = false;
    static boolean rezultatarab1 = false;
    static boolean rezultatarab2 = false;
    static boolean znak1 = false;
    static int num1 = 0;
    static int num2 = 0;
    static int summa;
    static final String[] RIM_ARRAY = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
            "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII",
            "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX",
            "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII",
            "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI",
            "XCVII", "XCVIII", "XCIX", "C"};
    static final String[] ARAB_ARRAY = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"};
    static final String[] ZNAK_ARRAY = {"+", "-", "*", "/"};
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String str1;
        str1 = sc.nextLine();
        String[] words = str1.split(" ");
        for (int i = 0; i < ARAB_ARRAY.length; i++) {
            if (ARAB_ARRAY[i].contentEquals(words[0])) {
                rezultatarab1 = true;
                num1 = i;
            }
            if (ARAB_ARRAY[i].contentEquals(words[2])) {
                rezultatarab2 = true;
                num2 = i;
            }
        }
        for (int i = 0; i < RIM_ARRAY.length; i++) {
            if (RIM_ARRAY[i].contentEquals(words[0])) {
                rezultatrim1 = true;
                num1 = i;
            }
            if (RIM_ARRAY[i].contentEquals(words[2])) {
                rezultatrim2 = true;
                num2 = i;
            }
        }

        for (int i = 0; i < ZNAK_ARRAY.length; i++) {
            if (ZNAK_ARRAY[i].contentEquals(words[1])) {
                znak1 = true;
                break;
            }
        }

        try {
            if(rezultatarab1 && rezultatarab2 || rezultatrim1 && rezultatrim2){

            }
            else {
                throw new NoNegativeNumbersException("Неверные операнды");
            }
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
            return;
        }

        try {
            if(words.length > 3){
                throw new NoNegativeNumbersException(" Неверное кол-во операндов ");
            }
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
            return;
        }

        try {
            if(num1 > 10 || num2 > 10){
                throw new NoNegativeNumbersException(" Операнды больше 10 ");
        }
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
            return;
        }

        try {
            if (znak1){
                try {
                    if (rezultatrim1 && rezultatrim2 ) {
                        System.out.println(calcrim(num1, num2, words));
                    }
                    if (rezultatarab1 && rezultatarab2){
                        System.out.println(calcarab(num1, num2, words));
                    }
                    if (rezultatrim1 && rezultatarab2 || rezultatarab1 && rezultatrim2){
                        throw new NoNegativeNumbersException(" Операнды не соотвествуют ");
                    }

                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
            else {
                throw new NoNegativeNumbersException(" Знак не является математической операцией ");
            }
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static String calcrim(int num1, int num2, String[] words) {
        if (znak1) {
            switch (words[1]) {
                case ("+"):
                    summa = num1 + num2;
                    break;
                case ("-"):
                    if (summa <= 0) {
                        throw new NoNegativeNumbersException("У Римлян нет отрицательных чисел");
                    } else {
                        summa = num1 - num2;
                        break;
                    }
                case ("/"):
                    if (num2 == 0) {
                        throw new ArithmeticException ("У Римлян нет 0 ");
                    } else {
                        summa = num1 / num2;
                        break;
                    }
                case ("*"):
                    summa = num1 * num2;
                    break;
            }
        }
        return RIM_ARRAY[summa];
    }

    public static int calcarab(int num1, int num2, String[] words) {
        if (znak1) {
            switch (words[1]) {
                case ("+"):
                    summa = num1 + num2;
                    break;
                case ("-"):
                    summa = num1 - num2;
                    break;
                case ("/"):
                    if (num2 == 0) {
                        throw new ArithmeticException("На ноль делить нельзя");
                    } else {
                        summa = num1 / num2;
                        break;
                    }
                case ("*"):
                    summa = num1 * num2;
                    break;
            }
        }
        return summa;
    }
}







