import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class GUIInterface extends JFrame {
    private MemberManager manager = new MemberManager();
    private JTextArea outputArea;

    public GUIInterface() {
        setTitle("Member Management System");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        JButton addBtn = new JButton("Add Member");
        JButton viewBtn = new JButton("View Members");
        JButton searchBtn = new JButton("Search by ID");
        JButton deleteBtn = new JButton("Delete Member");
        JButton sortBtn = new JButton("Sort by Name");

        topPanel.add(addBtn);
        topPanel.add(viewBtn);
        topPanel.add(searchBtn);
        topPanel.add(deleteBtn);
        topPanel.add(sortBtn);

        outputArea = new JTextArea();
        outputArea.setEditable(false);

        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        addBtn.addActionListener(e -> addMemberDialog());
        viewBtn.addActionListener(e -> viewMembers());
        searchBtn.addActionListener(e -> searchByIdDialog());
        deleteBtn.addActionListener(e -> deleteByIdDialog());
        sortBtn.addActionListener(e -> {
            manager.sortByName();
            viewMembers();
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void addMemberDialog() {
        try {
            String idStr = JOptionPane.showInputDialog(this, "Enter ID:");
            if (idStr == null) return;
            int id = Integer.parseInt(idStr.trim());
            String name = JOptionPane.showInputDialog(this, "Enter Name:");
            if (name == null) return;
            String type = JOptionPane.showInputDialog(this, "Enter Type:");
            if (type == null) return;
            String feeStr = JOptionPane.showInputDialog(this, "Enter Fee:");
            if (feeStr == null) return;
            double fee = Double.parseDouble(feeStr.trim());
            manager.addMember(new Member(id, name, type, fee));
            outputArea.append("Member added: " + id + " - " + name + "\n");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    private void viewMembers() {
        outputArea.setText("");
        List<Member> all = manager.getAll();
        if (all.isEmpty()) {
            outputArea.append("No members found.\n");
            return;
        }
        for (Member m : all) outputArea.append(m.toString() + "\n");
    }

    private void searchByIdDialog() {
        try {
            String idStr = JOptionPane.showInputDialog(this, "Enter ID to search:");
            if (idStr == null) return;
            int id = Integer.parseInt(idStr.trim());
            Member m = manager.searchById(id);
            if (m == null) JOptionPane.showMessageDialog(this, "Member not found.");
            else JOptionPane.showMessageDialog(this, m.toString());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    private void deleteByIdDialog() {
        try {
            String idStr = JOptionPane.showInputDialog(this, "Enter ID to delete:");
            if (idStr == null) return;
            int id = Integer.parseInt(idStr.trim());
            boolean removed = manager.removeMember(id);
            if (removed) outputArea.append("Member removed: " + id + "\n");
            else outputArea.append("No member with that ID.\n");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }
}

