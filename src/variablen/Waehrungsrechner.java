package variablen;

import java.util.Scanner;

/**
 * Währungsrechner für DM in Euro. Umrechnungskurs beträgt 1.96DM pro Euro
 */
public class Waehrungsrechner {
    static double EXCHANGE_RATE = 1.96;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Wilkommem zum Währungsrechner!");
        System.out.println("Geben Sie den Geldbetrag ein, den Sie in Euro umtauschen wollen: ");

        String input = sc.nextLine();
        double dm = Double.parseDouble(input);
        System.out.println("Der eingegebene Betrag wird in Euro umgerechnet...");

        double dmInEuro = calculateInEuro(dm);

        System.out.printf("%.2f DM entspricht %.2f €", dm, dmInEuro);

        sc.close();
    }

    private static double calculateInEuro(double dm) {
        return dm / EXCHANGE_RATE;
    }


}
