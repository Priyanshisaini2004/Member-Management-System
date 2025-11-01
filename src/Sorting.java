import java.util.List;

public class Sorting {

    // Sort members alphabetically by name (A-Z)
    public static void sortByName(List<Member> members) {
        int n = members.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                String name1 = members.get(j).getName().toLowerCase();
                String name2 = members.get(j + 1).getName().toLowerCase();

                if (name1.compareTo(name2) > 0) {
                    Member temp = members.get(j);
                    members.set(j, members.get(j + 1));
                    members.set(j + 1, temp);
                }
            }
        }
    }

    // Sort members by membership fee (low to high)
    public static void sortByFee(List<Member> members) {
        int n = members.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (members.get(j).getFee() > members.get(j + 1).getFee()) {
                    Member temp = members.get(j);
                    members.set(j, members.get(j + 1));
                    members.set(j + 1, temp);
                }
            }
        }
    }
}
