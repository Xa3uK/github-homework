package lesson10;

public class Fraction {
    private final int intPart;
    private final short decimalPart;
    public static final int DEGREE = 10;

    public Fraction(int intPart, short decimalPart) {
        this.intPart = intPart;
        this.decimalPart = decimalPart;
    }

    public Fraction(String str) {
        String[] number = str.split(",");
        this.intPart = Integer.parseInt(number[0]);
        if (Integer.parseInt(number[1]) > Short.MAX_VALUE) {
            throw new IllegalArgumentException("Decimal part of number " + str + " bigger then Short.MAX_VALUE (32767)");
        }
        if (Integer.parseInt(number[1]) < 0) {
            throw new IllegalArgumentException("Decimal part of number " + str + " is negative");
        } else {
            this.decimalPart = (short) Integer.parseInt(number[1]);
        }
    }

    public static int[] addition(Fraction num1, Fraction num2) {
        int[] result = new int[2];
        int[] decimals = decimalSameLengthMaker(num1.decimalPart, num2.decimalPart);
        int decimal1 = decimals[0];
        int decimal2 = decimals[1];
        result[0] = num1.intPart + num2.intPart;
        result[1] = decimal1 + decimal2;
        if (numLength(result[1]) > numLength(decimal1)) {
            result[1] = result[1] % numInDegrees(numLength(decimal1), DEGREE);
            result[0]++;
        }
        if (!isPositive(num1.intPart) || !isPositive(num2.intPart)) {
            if (num1.intPart * -1 > num2.intPart) {
                result = subtraction(signSwitch(num1), num2);
                result[0] *= -1;
            } else {
                result = subtraction(num2, signSwitch(num1));
            }
        }
        if (!isPositive(num1.intPart) && !isPositive(num2.intPart)) {
            result = addition(signSwitch(num1), signSwitch(num2));
            result[0] *= -1;
        }
        result[1] = result[0] < 0 ? result[1] * -1 : result[1];
        return result;
    }

    public static int[] subtraction(Fraction num1, Fraction num2) {
        int[] decimals = decimalSameLengthMaker(num1.decimalPart, num2.decimalPart);
        int decimal1 = decimals[0];
        int decimal2 = decimals[1];
        int[] result = new int[2];
        result[0] = num1.intPart - num2.intPart;
        if (num1.intPart > num2.intPart) {
            if (decimal1 > decimal2) {
                result[1] = decimal1 - decimal2;
            }
            if (decimal1 < decimal2) {
                result[1] = numInDegrees(numLength(decimal1), DEGREE) - (decimal2 - decimal1);
                result[0]--;
            }
        }
        if (num1.intPart < num2.intPart) {
            if (decimal1 > decimal2) {
                result[1] = numInDegrees(numLength(decimal1), DEGREE) - (decimal1 - decimal2);
                result[0]++;
            }
            if (decimal1 < decimal2) {
                result[1] = decimal2 - decimal1;
            }
        }
        if (!isPositive(num1.intPart) && isPositive(num2.intPart)) {
            result = addition(signSwitch(num1), num2);
            result[0] *= -1;
        }
        if (isPositive(num1.intPart) && !isPositive(num2.intPart)) {
            result = addition(num1, signSwitch(num2));
        }
        if (!isPositive(num1.intPart) && !isPositive(num2.intPart)) {
            if (num1.intPart < num2.intPart) {
                result = subtraction(signSwitch(num1), signSwitch(num2));
                result[0] *= -1;
            }
            if (num1.intPart > num2.intPart) {
                result = subtraction(signSwitch(num2), signSwitch(num1));
            }
        }
        result[1] = result[0] < 0 ? result[1] * -1 : result[1];
        return result;
    }

    public static int numInDegrees(int length, int number) {
        if (length == 1) {
            return number;
        }
        return number * numInDegrees(length - 1, number);
    }

    public static int numLength(int number) {
        if (number == 0) {
            return 0;
        }
        return 1 + numLength(number / 10);
    }

    public static int[] decimalSameLengthMaker(short num1, short num2) {
        int[] decimals = new int[2];
        decimals[0] = num1;
        decimals[1] = num2;
        int length = numLength(num1) - numLength(num2);
        if (length > 0) {
            decimals[1] = num2 * numInDegrees(length, 10);
        }
        if (length < 0) {
            decimals[0] = num1 * numInDegrees(length * -1, 10);
        }
        return decimals;
    }

    public static boolean isPositive(int number) {
        return number > 0;
    }

    public static Fraction signSwitch(Fraction fraction) {
        return new Fraction(fraction.intPart * -1, fraction.decimalPart);
    }
}
