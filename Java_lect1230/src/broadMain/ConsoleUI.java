package broadMain;

import java.util.Scanner;

public class ConsoleUI {
    private static final Scanner scan = new Scanner(System.in);

    public static String getInput(String message) {
        System.out.print(message);
        return scan.nextLine();
    }

    public static void printMenu(String... options) {
        System.out.println("-----------------");
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
        System.out.println("-----------------");
        System.out.print("메뉴 입력: ");
    }

    public static int getIntInput(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력하세요.");
            }
        }
    }

    public static void closeScanner() {
        scan.close();
    }
}
