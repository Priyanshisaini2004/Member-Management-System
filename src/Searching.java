import java.util.List;

public class Searching {

    // Linear search by Member ID
    public static Member searchById(List<Member> members, int id) {
        for (Member m : members) {
            if (m.getId() == id) {
                return m; // found
            }
        }
        return null; // not found
    }

    // Linear search by Member name
    public static Member searchByName(List<Member> members, String name) {
        for (Member m : members) {
            if (m.getName().equalsIgnoreCase(name)) {
                return m;
            }
        }
        return null;
    }

    // Binary search (works only if list sorted by ID)
    public static Member binarySearchById(List<Member> members, int id) {
        int left = 0;
        int right = members.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int midId = members.get(mid).getId();

            if (midId == id) {
                return members.get(mid);
            } else if (midId < id) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }
}
