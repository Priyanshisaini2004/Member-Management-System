// PremiumMember.java
public class PremiumMember extends Member {
    private boolean hasPersonalTrainer;

    public PremiumMember(String id, String firstName, String lastName, int age, double baseFee, int performanceRating, boolean hasPersonalTrainer) {
        super(id, firstName, lastName, age, baseFee, performanceRating);
        this.hasPersonalTrainer = hasPersonalTrainer;
    }

    public boolean hasPersonalTrainer() { return hasPersonalTrainer; }
    public void setPersonalTrainer(boolean v) { this.hasPersonalTrainer = v; }

    @Override
    public double calculateMonthlyFee() {
        double fee = baseFee;
        if (hasPersonalTrainer) fee += 30.0;
        if (performanceRating >= 90) {
            fee *= 0.80; // strong reward
        } else if (performanceRating < 40) {
            fee *= 1.03;
        }
        return fee;
    }

    @Override
    public String getMemberType() {
        return "Premium";
    }

    @Override
    public String toCSV() {
        return super.toCSV() + "," + (hasPersonalTrainer ? "Y" : "N");
    }
}
