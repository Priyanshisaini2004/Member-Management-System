// RegularMember.java
public class RegularMember extends Member {
    public RegularMember(String id, String firstName, String lastName, int age, double baseFee, int performanceRating) {
        super(id, firstName, lastName, age, baseFee, performanceRating);
    }

    @Override
    public double calculateMonthlyFee() {
        if (performanceRating >= 80) {
            return baseFee * 0.90; // reward
        } else if (performanceRating < 40) {
            return baseFee * 1.05; // small penalty
        } else {
            return baseFee;
        }
    }

    @Override
    public String getMemberType() {
        return "Regular";
    }
}
