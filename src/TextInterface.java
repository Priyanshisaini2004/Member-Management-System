import java.util.Scanner;
import java.util.List;

public class TextInterface {
    private MemberManager manager = new MemberManager();
    private Scanner sc = new Scanner(System.in);

    public void start() {
        boolean running = true;
        while (running) {
            System.out.println("\n--- Member Management (Text) ---");
            System.out.println("1. Add Member");
            System.out.println("2. View Members");
            System.out.println("3. Search by ID");
            System.out.println("4. Delete Member");
            System.out.println("5. Sort by Name");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            String line = sc.nextLine();
            int choice = 0;
            try { choice = Integer.parseInt(line); } catch (Exception e) { choice = 0; }

            switch (choice) {
                case 1: addMember(); break;
                case 2: viewMembers(); break;
                case 3: searchById(); break;
                case 4: deleteMember(); break;
                case 5: sortByName(); break;
                case 6: running = false; break;
                default: System.out.println("Invalid choice."); break;
            }
        }
        System.out.println("Exiting Text Interface.");
    }

    private void addMember() {
        try {
            System.out.print("Enter ID: ");
            int id = Integer.parseInt(sc.nextLine());
            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Type: ");
            String type = sc.nextLine();
            System.out.print("Enter Fee: ");
            double fee = Double.parseDouble(sc.nextLine());
            manager.addMember(new Member(id,name,type,fee));
            System.out.println("Member added.");
        } catch (Exception e) {
            System.out.println("Error adding member: " + e.getMessage());
        }
    }

    private void viewMembers() {
        List<Member> all = manager.getAll();
        if (all.isEmpty()) {
            System.out.println("No members found.");
            return;
        }
        for (Member m : all) System.out.println(m);
    }

    private void searchById() {
        try {
            System.out.print("Enter ID to search: ");
            int id = Integer.parseInt(sc.nextLine());
            Member m = manager.searchById(id);
            if (m == null) System.out.println("Member not found.");
            else System.out.println("Found: " + m);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void deleteMember() {
        try {
            System.out.print("Enter ID to delete: ");
            int id = Integer.parseInt(sc.nextLine());
            boolean removed = manager.removeMember(id);
            if (removed) System.out.println("Member removed.");
            else System.out.println("No member with that ID.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void sortByName() {
        manager.sortByName();
        System.out.println("Members sorted by name.");
    }
}

