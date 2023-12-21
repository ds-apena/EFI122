package string;

import java.util.Scanner;

public class CrossAddition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Geben Sie eine Zahl ein: ");
        String input = sc.next();

        int number = Integer.parseInt(input);

        if (number > 100) {
            String[] arr = input.split("");
            int sum = 0;
            for (String s : arr) {
                int temp = Integer.parseInt(s);
                sum += temp;
            }

            System.out.println(sum);
        } else {
            System.out.println(number);
        }

        sc.close();
    }
}
