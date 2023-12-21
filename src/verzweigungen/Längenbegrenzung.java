package verzweigungen;

import java.util.Scanner;

public class Längenbegrenzung {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean validLength = false;
        do {
            System.out.print("Geben Sie einen beliebigen String ein: ");
            String inputString = sc.next();
            int stringLength = inputString.length();

            validLength = validateStringLength(stringLength);
        } while (!validLength);

        sc.close();
    }

    private static boolean validateStringLength(int stringLength) {
        boolean validLength = false;
        if (stringLength > 20) {
            System.out.println("Ungültige Eingabe. Der Text enthält mehr als 20 Zeichen.");
        } else if (stringLength >= 8) {
            System.out.println("Gültige Eingabe.");
            validLength = true;
        } else {
            System.out.println("Ungültige Eingabe. Der Text enthält weniger als 8 Zeichen.");
        }

        return validLength;
    }
}
