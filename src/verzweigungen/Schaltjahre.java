package verzweigungen;

import java.util.Scanner;

public class Schaltjahre {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("""
                            
                            Dieses Programm überprüft, ob der vom Benutzer eingegebene Jahreszahl ein Schaltjahr ist oder nicht.
                            
                            """);
        System.out.print("Geben Sie ein beliebiges Jahr ein: ");

        String input = sc.next();
        int year = Integer.parseInt(input);
        boolean isLeap = isLeapYear(year);

        System.out.println(isLeap);

        sc.close();
    }

    private static boolean isLeapYear(int year) {
        boolean isLeap = false;
        if(year % 4 == 0) {
            if (year % 100 == 0) {
                isLeap = year % 400 == 0;
            }
            isLeap = true;
        }

        return isLeap;
    }
}
