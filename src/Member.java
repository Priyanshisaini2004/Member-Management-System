public class Member {
    private int id;
    private String name;
    private String type;
    private double fee;

    public Member(int id, String name, String type, double fee) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.fee = fee;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getType() { return type; }
    public double getFee() { return fee; }

    public void setName(String name) { this.name = name; }
    public void setType(String type) { this.type = type; }
    public void setFee(double fee) { this.fee = fee; }

    public String toCSV() {
        return id + "," + name + "," + type + "," + fee;
    }

    public static Member fromCSV(String line) {
        try {
            String[] parts = line.split(",");
            int id = Integer.parseInt(parts[0]);
            String name = parts[1];
            String type = parts[2];
            double fee = Double.parseDouble(parts[3]);
            return new Member(id, name, type, fee);
        } catch (Exception e) {
            return null;
        }
    }

    public String toString() {
        return id + " | " + name + " | " + type + " | $" + fee;
    }
}

