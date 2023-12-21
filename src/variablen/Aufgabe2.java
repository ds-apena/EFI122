package variablen;

import java.util.Scanner;

public class Aufgabe2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Geben Sie zwei Kommazahlen ein: ");
        double num1 = Double.parseDouble(sc.nextLine());
        double num2 = Double.parseDouble(sc.nextLine());

        double sum = sum(num1, num2);
        double subtraction = subtract(num1, num2);
        double multiplication = multiply(num1, num2);
        double division = divide(num1, num2);

        System.out.printf("Summe: %.2f\n", sum);
        System.out.printf("Differenz: %.2f\n", subtraction);
        System.out.printf("Multiplikation: %.2f\n", multiplication);
        System.out.printf("Division: %.2f", division);
    }

    private static double divide(double num1, double num2) {
        return num1 / num2;
    }

    private static double multiply(double num1, double num2) {
        return num1 * num2;
    }

    private static double subtract(double num1, double num2) {
        return num1 - num2;
    }

    private static double sum (double num1, double num2) {
        return num1 + num2;
    }
}
