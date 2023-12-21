package verzweigungen;

import java.util.Scanner;

public class PINCode {
    static String PINCODE = "2884";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean validCode = false;
        do {
            printHeader();
            String pinCode = sc.next();
            validCode = validateCode(pinCode);
            if (validCode){
                System.out.println("*** Das Gerät wurde entsperrt             ***");

            } else {
                System.out.println("*** Der eingegebene PIN-Code ist leider   ***");
                System.out.println("*** falsch. Versuchen Sie bitte erneut    ***");
            }
        } while (!validCode);

        sc.close();
    }

    private static void printHeader() {
        System.out.println("*********************************************");
        System.out.println("**** Bitte geben Sie Ihr PIN-Code ein, *****");
        System.out.println("**** um das Gerät zu entsperren        *****");
        System.out.println("*********************************************");
        System.out.println();
    }

    private static boolean validateCode(String pinCode) {
        return pinCode.equals(PINCODE);
    }
}
