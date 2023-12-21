package verzweigungen;

import java.util.Scanner;

/**
 * Programm zur Lösung von quadratischen Gleichungen
 */

public class QuadratischeGleichungen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Geben Sie die entsprechenden Werte für folgenden Variablen: ");
        System.out.println("Anmerkung: Brüche müssen als Fließkommazahl eingegeben werden");
        System.out.print("a: ");
        double a = Double.parseDouble(sc.next());
        System.out.print("b: ");
        double b = Double.parseDouble(sc.next());
        System.out.print("c: ");
        double c = Double.parseDouble(sc.next());

        try {
            applyQuadraticFormula(a, b, c);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }

    private static void applyQuadraticFormula(double a, double b, double c) throws ArithmeticException {
        double b2 = Math.pow(b, 2);
        double d = Math.sqrt(b2 - 4 * a * c);

        if (d > 0) {
            double x1 = (-1 * b + d) / 2 * a;
            double x2 = (-1 * b - d) / 2 * a;
            System.out.printf("X1 = %f  X2 = %f", x1, x2);
        } else if (d == 0) {
            double x = (-1 * b) / (2 * a);
            System.out.printf("X = %f", x);
        } else {
            throw new ArithmeticException("Die quadratische Formel hat keine Lösungen.");
        }
    }
}
