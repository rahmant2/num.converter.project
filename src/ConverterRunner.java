import java.util.Scanner;

class ConverterRunner {
    public static void main(String[] args) {
        System.out.println("Welcome to the Number Converter!");
        System.out.println("--------------------------------");
        System.out.print("Enter the base of your number (2, 8, or 10): ");

        Scanner s = new Scanner(System.in);
        int base = s.nextInt();

        System.out.print("Enter your number: ");
        int number = s.nextInt();

        s.close();

        NumberConverter nc = new NumberConverter(number, base);

        if (base == 10) {
            System.out.println("\nBinary number: " + nc.convertToBinary());
            System.out.println("Octal number: " + nc.convertToOctal());
            System.out.println("Hexadecimal number: " + nc.convertToHexadecimal());
        } else if (base == 2) {
            System.out.println("\nDecimal number: " + nc.convertToDecimal());
            System.out.println("Octal number: " + nc.convertToOctal());
            System.out.println("Hexadecimal number: " + nc.convertToHexadecimal());
        } else if (base == 8) {
            System.out.println("\nDecimal number: " + nc.convertToDecimal());
            System.out.println("Binary number: " + nc.convertToBinary());
            System.out.println("Hexadecimal number: " + nc.convertToHexadecimal());
        } else if (base == 16) {
            System.out.println("\nDecimal number: " + nc.convertToDecimal());
            System.out.println("Binary number: " + nc.convertToBinary());
            System.out.println("Octal number: " + nc.convertToOctal());
        }
    }
}