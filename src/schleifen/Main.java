package schleifen;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Handy h1 = new Handy("Apple Inc.", "iPhone 12 Mini", "1234", "2884", "341256");

        if (!h1.loginUser(sc)) {
            System.out.println("Anmeldung vorläufig gesperrt...");
        }
    }
}
