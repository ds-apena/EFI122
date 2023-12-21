package variablen;

import java.util.Scanner;

public class Kraftstoffverbrauch {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Geben Sie folgende Daten ein: ");
        System.out.println("Zurückgelegte Strecke in km: ");

        String input = sc.next();
        double traveledDistance = Double.parseDouble(input);

        System.out.println("Verbrauchte Kraftstoffmenge: ");
        input = sc.next();
        double consumedFuel = Double.parseDouble(input);

        double averageFuelConsumption = calculateAverageFuelConsumption(traveledDistance, consumedFuel);
        System.out.printf("Durchschnittlicher Kraftstoffverbrauch auf 100km: %.2f ", averageFuelConsumption);

        sc.close();
    }

    private static double calculateAverageFuelConsumption(double traveledDistance, double consumedFuel) {
        return (consumedFuel * 100) / traveledDistance;
    }
}
