package verzweigungen;

import java.util.Scanner;

/**
 * Vermerk: Taschenrechner-Aufgabe übersprungen (Aufgabe 5)
 */

public class KFZVersicherung {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("""
                            ***************************************
                            ***    KFZ-Versicherungsrechner    ***");
                            ***************************************
                            """);

        System.out.print("Grundbetrag: ");
        double baseFee  = Double.parseDouble(sc.next());
        System.out.print("Alter: ");
        int age = Integer.parseInt(sc.next());
        System.out.print("Jährliche Fahrleistung: ");
        double annualMileage = Double.parseDouble(sc.next());
        System.out.print("Garagenfahrzeug (ja/nein):  ");
        String parkingFee = sc.next();

        double totalFee = baseFee;

        totalFee += checkDriversAge(baseFee, age);
        totalFee += checkAnnualMileage(baseFee, annualMileage);
        totalFee += isParkingFee(baseFee, parkingFee);

        System.out.println("Gesamtbetrag: " + totalFee);

        sc.close();
    }

    private static double checkDriversAge(double baseFee, int age) {
        return age <= 25 ? baseFee * 0.4 : -(baseFee * 0.1) ;
    }

    private static double checkAnnualMileage(double baseFee, double annualMileage) {
        return annualMileage > 15_000 ? baseFee * 0.20 : -(baseFee * 0.1);
    }

    private static double isParkingFee(double baseFee, String parkingFee) {
        return parkingFee.equalsIgnoreCase("nein") ? baseFee * 0.05 : -(baseFee * 0.05);
    }
}
