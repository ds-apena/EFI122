package verzweigungen;

import java.util.Scanner;

public class Passworteingabe {
    static String PASSWORD = "zmQ15!3Z";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean validPassword = false;
        do {
            printHeader();
            String userPassword = sc.next();
            validPassword = validatePassword(userPassword);
            if (validPassword){
                System.out.println("*** Das Gerät wurde entsperrt             ***");

            } else {
                System.out.println("*** Das eingegebene Passwort ist leider   ***");
                System.out.println("*** falsch. Versuchen Sie bitte erneut    ***");
            }
        } while (!validPassword);

        sc.close();
    }

    private static void printHeader() {
        System.out.println("*********************************************");
        System.out.println("**** Bitte geben Sie Ihr Passwort ein,  *****");
        System.out.println("**** um das Gerät zu entsperren         *****");
        System.out.println("*********************************************");
        System.out.println();
    }

    private static boolean validatePassword(String userPassword) {
        return userPassword.equals(PASSWORD);
    }
}
