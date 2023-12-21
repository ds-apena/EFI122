package string;

import java.util.Scanner;

public class ASCIICode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("ASCII Code: ");
        int asciiCode = Integer.parseInt(sc.next());
        System.out.println((char) asciiCode);

        sc.close();
    }
}
