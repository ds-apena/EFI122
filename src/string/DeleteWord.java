package string;

import java.util.Scanner;

public class DeleteWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Geben Sie einen Text ein und danach das Wort, das sie vom Text entfernen wollen: ");
        String text = sc.nextLine();
        System.out.print("Wort: ");
        String word = sc.next();

        if (text.contains(word))
            System.out.println(text.replace(word, ""));
        else
            System.out.println("Word not found. ");

        sc.close();
    }
}
