package ISO2.Exe2.model;

public class FareOffer {
    private final String name;
    private final double discountPercentage;

    public FareOffer(String name, double discountPercentage) {
        this.name = name;
        this.discountPercentage = discountPercentage;
    }

    public String getName() { return name; }
    public double getDiscountPercentage() { return discountPercentage; }
}
