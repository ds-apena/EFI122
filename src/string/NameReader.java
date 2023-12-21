package string;

import java.util.Scanner;

public class NameReader {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Vorname: ");
        String name = keyboard.next();

        System.out.print("Nachname: ");
        String surname = keyboard.next();

        System.out.println("Hello, " + name + " " + surname);
        System.out.println("Deine Initialen: " + name.charAt(0) + surname.charAt(0));
        keyboard.close();
    }
}
