import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Member Management System (MMS)");
        System.out.println("1. Use Text Interface");
        System.out.println("2. Use GUI Interface");
        System.out.print("Enter choice: ");

        Scanner sc = new Scanner(System.in);
        int choice = 1;
        try {
            choice = Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            System.out.println("Invalid input, defaulting to Text Interface.");
        }

        if (choice == 2) {
            javax.swing.SwingUtilities.invokeLater(() -> {
                new GUIInterface();
            });
        } else {
            TextInterface text = new TextInterface();
            text.start();
        }
        sc.close();
    }
}

