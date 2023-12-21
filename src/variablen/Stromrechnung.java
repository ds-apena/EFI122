package variablen;

enum Preisliste {
    KWH_PRICE(0.13),
    CONNECTION_FEE(27.30);

    public final double element;

    Preisliste(double price) {
        this.element = price;
    }
}

public class Stromrechnung {
    public static void main(String[] args) {

        double KWH_PRICE = 0.13;
        double CONNECTION_FEE = 27.30;
        double consumed_kwh = 100;
        double consumption = KWH_PRICE * consumed_kwh;
        double sum = CONNECTION_FEE + consumption;
        double VAT = sum * 0.19;
        double sumWithVAT = VAT + sum;

        System.out.println();
        System.out.println();
        System.out.println("\tRechnung\n");
        System.out.printf("Preis für eine kWh: \t\t\t\t%.2f\n", KWH_PRICE);
        System.out.printf("Anschlussgrundgebühr: \t\t\t\t%.2f\n", CONNECTION_FEE);
        System.out.printf("Verbrauch: \t%.2f kWH * %.2f € =\t+%.2f\n", KWH_PRICE, CONNECTION_FEE, consumption);
        System.out.println("\t\t\t\t\t\t\t\t\t---------- ");
        System.out.printf("\t\t\t\t\t\t\t\t\t%.2f", sum);
        System.out.println();
        System.out.printf("MwSt: \t\t\t\t\t\t\t\t+%.2f\n", VAT);
        System.out.println("\t\t\t\t\t\t\t\t\t---------- ");
        System.out.printf("Endbetrag: \t\t\t\t\t\t\t%.2f €", sumWithVAT);

    }


}
