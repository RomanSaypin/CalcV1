package com.company;

public class DataProcessor {
    private static Convector convector;
    private static String[] operator = new String[]{"+", "-", "*", "/"};
    private static String[] numbers = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
    private static String input;
    private static String strNumOne;
    private static String strOperator;
    private static String strNumTwo;
    private static String[] symbols;

    public DataProcessor(String input) {
        DataProcessor.input = input;
    }

    public static void splittingTheIntroductoryLine() throws Exception {
        symbols = input.split(" ");
        strNumOne = symbols[0];
        strOperator = symbols[1];
        strNumTwo = symbols[2];
        int x = checkingNumbers(strNumOne);
        int y = checkingNumbers(strNumTwo);
        int zOperator = checkingOperator(strOperator);
        if (x == y) {
            convector = new Convector(strNumOne, strOperator, strNumTwo, x, y);
            convector.convectorNumbers();
        } else {
            throw new Exception();
        }
    }

    private static int checkingOperator(String strOperator) throws Exception {
        int yI = 0;

        for(int i = 0; i < operator.length; ++i) {
            if (operator[i].equals(strOperator)) {
                yI = 1;
                break;
            }
        }

        if (yI > 0) {
            return 1;
        } else {
            throw new Exception();
        }
    }

    private static int checkingNumbers(String str) throws Exception {
        int xI = 0;

        for(int i = 0; i < numbers.length; ++i) {
            if (numbers[i].equals(str)) {
                xI = i;
                break;
            }

            xI = -1;
        }

        if (xI < 10 && xI > 0) {
            return 1;
        } else if (xI >= 10) {
            return 2;
        } else {
            throw new Exception();
        }
    }
}
