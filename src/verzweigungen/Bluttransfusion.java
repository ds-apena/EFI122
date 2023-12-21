package verzweigungen;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Anmerkung: Implementierung des Algorithmus muss noch geklärt werden. Planung!
 */

public class Bluttransfusion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] bloodGroups = {"0-", "0+", "B-", "B+", "A-", "A+", "AB-", "AB+"};
        Character[][] bloodGroupsMatrix = {
                {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                {'x', '-','x', '-', 'x', '-', 'x', '-'},
                {'x', 'x', '-', '-', 'x', 'x', '-', '-'},
                {'x', '-', '-', '-', 'x', '-', '-', '-'},
                {'x', 'x', 'x', 'x', '-', '-', '-', '-'},
                {'x', '-', 'x', '-', '-', '-', '-', '-'},
                {'x', 'x', '-', '-', '-', '-', '-', '-'},
                {'x', '-', '-', '-', '-', '-', '-', '-'}};

        System.out.print("Sender-Blutgruppe: ");
        String donor = sc.next();
        System.out.print("Empfänger-Blutgruppe: ");
        String receiver = sc.next();

        if (Arrays.asList(bloodGroups).contains(receiver)) {
            for (int i=0; i< bloodGroups.length; i++) {
                if (bloodGroups[i].equalsIgnoreCase(receiver)) {

                }
            }
        }

        for (int i=0; i<bloodGroupsMatrix.length; ++i) {
            for (int j=0; j<bloodGroupsMatrix[i].length; ++j) {
                System.out.print(bloodGroupsMatrix[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }


}
