import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MemberManager {
    private List<Member> members = new ArrayList<>();
    private final String dataFile = "data/members.txt";

    public MemberManager() {
        loadFromFile();
    }

    public void addMember(Member m) {
        members.add(m);
        saveToFile();
    }

    public boolean removeMember(int id) {
        boolean removed = members.removeIf(m -> m.getId() == id);
        if (removed) saveToFile();
        return removed;
    }

    public Member searchById(int id) {
        for (Member m : members) {
            if (m.getId() == id) return m;
        }
        return null;
    }

    public List<Member> getAll() {
        return members;
    }

    public void sortByName() {
        int n = members.size();
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (members.get(j).getName().compareToIgnoreCase(members.get(j+1).getName()) > 0) {
                    Member tmp = members.get(j);
                    members.set(j, members.get(j+1));
                    members.set(j+1, tmp);
                }
            }
        }
        saveToFile();
    }

    private void loadFromFile() {
        members.clear();
        File f = new File(dataFile);
        if (!f.exists()) {
            try {
                f.getParentFile().mkdirs();
                f.createNewFile();
            } catch (IOException e) {
                System.out.println("Could not create data file: " + e.getMessage());
                return;
            }
        }
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                Member m = Member.fromCSV(line);
                if (m != null) members.add(m);
            }
        } catch (IOException e) {
            System.out.println("Error reading data file: " + e.getMessage());
        }
    }

    private void saveToFile() {
        File f = new File(dataFile);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(f,false))) {
            for (Member m : members) {
                bw.write(m.toCSV());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing data file: " + e.getMessage());
        }
    }
}

