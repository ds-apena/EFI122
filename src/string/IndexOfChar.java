package string;

import java.util.Scanner;

public class IndexOfChar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Bitte tippen Sie einen vollständigen Satz ein: ");
        String input = sc.nextLine();

        System.out.println("Leerzeichen: ");
        System.out.println("Erste Position: " + input.indexOf(" "));
        System.out.println("Letzte Position: " + input.lastIndexOf(" "));

        sc.close();
    }
}
