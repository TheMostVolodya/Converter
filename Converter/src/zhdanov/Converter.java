package zhdanov;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.String.format;

public class Converter {

    private static final Logger LOGGER = Logger.getLogger("Converter");


    public static final String CONSOLE_MESSAGE_RESULT = "Число %s в двоичной системе счисления = %s";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int systemNum = 0;
        do {
            LOGGER.log(Level.INFO, "Введите требуемую систему счисления для вводимого числа:");
            LOGGER.log(Level.INFO, "2  <-------- двоичная");
            LOGGER.log(Level.INFO, "10 <-------- десятичная");
            try {
                systemNum = sc.nextInt();
                switch (systemNum) {
                    case 2 -> givenBinaryNumberThenConvertToDecimalNumber();
                    case 10 -> givenDecimalNumberThenConvertToBinaryNumber();
                    default -> LOGGER.log(Level.INFO, "Введено неверное число");
                }
            } catch (Exception e) {
                LOGGER.log(Level.WARNING, "Введено неверное значение, error: {0}", e.getMessage());
            }
        } while (systemNum == 2 || systemNum == 10);
    }


    static void givenDecimalNumberThenConvertToBinaryNumber() {
        Scanner sc = new Scanner(System.in);

        char letter;
        int number; // вводимое число
        int ns; //номер системы счисления

        do {
            do {
                LOGGER.log(Level.INFO, "Введите число в диапозоне 0-10000: ");
                number = sc.nextInt();
                if (number < 0 || number > 10000) {
                    LOGGER.log(Level.INFO, "Число не в ходит в указанный диапозон, повторите попытку!");
                }
            } while (number < 0 || number > 10000);
            LOGGER.log(Level.INFO, "Введите систему счисления: ");
            LOGGER.log(Level.INFO, "2  <-------- двоичная");
            LOGGER.log(Level.INFO, "8  <-------- восьмеричная");
            LOGGER.log(Level.INFO, "16 <-------- шестнадцатеричная");
            ns = sc.nextInt();

            switch (ns) {
                case 2:
                    String result = Long.toBinaryString(number);
                    LOGGER.log(Level.INFO, format(CONSOLE_MESSAGE_RESULT, number, result));
                    break;
                case 8:
                    result = Long.toOctalString(number);
                    LOGGER.log(Level.INFO, format(CONSOLE_MESSAGE_RESULT, number, result));
                    break;
                case 16:
                    result = Long.toHexString(number).toUpperCase();
                    LOGGER.log(Level.INFO, format(CONSOLE_MESSAGE_RESULT, number, result));
                    break;
                default:
                    LOGGER.log(Level.INFO, "Такой нет, повторите попытку");
            }
            letter = sc.next().charAt(0);
        } while (letter != 'e' && letter != 'E');
    }


    static void givenBinaryNumberThenConvertToDecimalNumber() {
        Scanner sc = new Scanner(System.in);

        char letter;
        String number; // вводимое число


        do {
            LOGGER.log(Level.INFO, "Введите бинарное число");
            number = sc.nextLine();
            int result = Integer.parseInt(number, 2);
            LOGGER.log(Level.INFO, format(CONSOLE_MESSAGE_RESULT, number, result));
            letter = sc.next().charAt(0);
        } while (letter != 'e' && letter != 'E');

    }
}
