package string;

import java.util.Scanner;

public class ToLowerCase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Geben Sie ein Wort ein: ");
        String input = sc.next();

        System.out.println(input.toLowerCase());

        sc.close();
    }
}
