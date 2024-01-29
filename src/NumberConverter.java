public class NumberConverter {
    private int[] digits;
    private int base;

    public NumberConverter(int number, int base) {
        if (base != 2 && base != 8 && base != 10) {
            throw new IllegalArgumentException("Invalid base. Please enter 2, 8, or 10.");
        }

        String numberAsString = Integer.toString(number);

        if (!isValidNumber(numberAsString, base)) {
            throw new IllegalArgumentException("Invalid number for the selected base.");
        }

        digits = new int[numberAsString.length()];
        for (int i = 0; i < numberAsString.length(); i++) {
            String single = numberAsString.substring(i, i + 1);
            int d = Integer.parseInt(single, base);
            digits[i] = d;
        }

        this.base = base;
    }

    /**
     *
     * @param number - number that is being converted
     * @param base - base of number
     * @return - if the number and its base are valid
     */

    private boolean isValidNumber(String number, int base) {
        String validChars;
        switch (base) {
            case 2:
                validChars = "01";
                break;
            case 8:
                validChars = "01234567";
                break;
            case 10:
                validChars = "0123456789";
                break;
            default:
                return false;
        }

        for (char digit : number.toCharArray()) {
            if (validChars.indexOf(digit) == -1) {
                return false;
            }
        }
        return true;
    }
    /*
     * converts number to binary
     */
    public String convertToBinary() {
        return Integer.toBinaryString(Integer.parseInt(displayOriginalNumber(), base));
    }
    /*
     * converts number to octal
     */

    public String convertToOctal() {
        return Integer.toOctalString(Integer.parseInt(displayOriginalNumber(), base));
    }
    /*
     * converts number to hexadecimal
     */
    public String convertToHexadecimal() {
        return Integer.toHexString(Integer.parseInt(displayOriginalNumber(), base)).toUpperCase();
    }

    public String convertToDecimal() {
        int length = digits.length;
        int result = 0;

        for (int i = 0; i < length; i++) {
            int columnValue = (int) Math.pow(base, length - 1 - i);
            result += digits[i] * columnValue;
        }

        return Integer.toString(result);
    }

    public String displayOriginalNumber() {
        StringBuilder o = new StringBuilder();
        for (int digit : digits) {
            o.append(digit);
        }
        return o.toString();
    }
}