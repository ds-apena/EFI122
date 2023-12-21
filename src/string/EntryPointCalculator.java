package string;

import java.math.BigInteger;
import java.util.Scanner;

public class EntryPointCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        IBANCalculator ibanCalculator= new IBANCalculator();

        String countryCode = "DE";
        String blz = "37050299";
        String accountNr = "0000684712";


//        System.out.print("Ländercode: ");
//        String countryCode = sc.next();
//        System.out.print("Kontonr.: ");
//        String accountNr = sc.next();
//        System.out.print("Bankleitzahl: ");
//        String blz = sc.next();

        // Validation of country code. Germany could be used as a standard unless otherwise specified.
        String iban = ibanCalculator.generateIBAN(countryCode, blz, accountNr);
        System.out.println(iban);

        sc.close();
    }
}
