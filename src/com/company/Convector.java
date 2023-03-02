package com.company;

public class Convector {
    private Output out;
    private String strNumOne;
    private String strOperator;
    private String strNumTwo;
    private int x;
    private int y;
    private int numOne;
    private int numTwo;
    private static String[] operator = new String[]{"+", "-", "*", "/"};
    private static String[] arabicNumerals = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    private static String[] romanNumerals = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};

    public Convector(String strNumOne, String strOperator, String strNumTwo, int x, int y) {
        this.x = x;
        this.y = y;
        this.strNumOne = strNumOne;
        this.strOperator = strOperator;
        this.strNumTwo = strNumTwo;
    }

    public void convectorNumbers() throws Exception {
        int i;
        if (this.x == 1) {
            for(i = 0; i < arabicNumerals.length; ++i) {
                if (arabicNumerals[i].equals(this.strNumOne)) {
                    this.numOne = i + 1;
                }

                if (arabicNumerals[i].equals(this.strNumTwo)) {
                    this.numTwo = i + 1;
                }
            }
        } else {
            for(i = 0; i < romanNumerals.length; ++i) {
                if (romanNumerals[i].equals(this.strNumOne)) {
                    this.numOne = i + 1;
                }

                if (romanNumerals[i].equals(this.strNumTwo)) {
                    this.numTwo = i + 1;
                }
            }
        }

        this.arithmeticOperations(this.numOne, this.numTwo, this.strOperator);
    }

    private void arithmeticOperations(int numOne, int numTwo, String strOperator) throws Exception {
        int numberOperator = 0;

        for(int i = 0; i < operator.length; ++i) {
            if (operator[i].equals(strOperator)) {
                numberOperator = i + 1;
                break;
            }
        }

        int result;
        if (numberOperator == 1) {
            result = numOne + numTwo;
        } else if (numberOperator == 2) {
            result = numOne - numTwo;
        } else if (numberOperator == 3) {
            result = numOne * numTwo;
        } else {
            result = numOne / numTwo;
        }

        if (this.x == 2 && result <= 0) {
            throw new Exception();
        } else {
            this.inverterNumber(result);
        }
    }

    private void inverterNumber(int result) {
        String res;
        if (this.x == 1) {
            res = String.valueOf(result);
        } else {
            res = this.inverterOfArabicNumbersInRoman(result);
        }

        this.out = new Output(res);
    }

    private String inverterOfArabicNumbersInRoman(int result) {
        int x = result / 10;
        int y = result % 10;
        String strY = null;
        String strResult = null;
        int i;
        if (result <= 10) {
            for(i = 0; i < romanNumerals.length; ++i) {
                if (result - i == 1) {
                    return romanNumerals[i];
                }
            }
        } else {
            if (result == 100) {
                return "C";
            }

            String var10000;
            switch(x) {
                case 1:
                    var10000 = "X";
                    break;
                case 2:
                    var10000 = "XX";
                    break;
                case 3:
                    var10000 = "XXX";
                    break;
                case 4:
                    var10000 = "XL";
                    break;
                case 5:
                    var10000 = "L";
                    break;
                case 6:
                    var10000 = "LX";
                    break;
                case 7:
                    var10000 = "LXX";
                    break;
                case 8:
                    var10000 = "LXXX";
                    break;
                case 9:
                    var10000 = "XC";
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + result);
            }

            String strX = var10000;

            for(i = 0; i < romanNumerals.length; ++i) {
                if (y - i == 1) {
                    strY = romanNumerals[i];
                    break;
                }
            }

            if (strY == null) {
                strResult = strX;
            } else {
                strResult = strX + strY;
            }
        }

        return strResult;
    }
}
