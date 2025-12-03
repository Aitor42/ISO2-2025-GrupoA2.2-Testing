package ISO2.Exe2.model;

public class Customer {
    private final Demographics demographics;
    private final TravelProfile travelProfile;
    private final FinancialProfile financialProfile;

    private Customer(Builder b) {
        this.demographics = new Demographics(b.age, b.isStudent, b.livesWithParents);
        this.travelProfile = new TravelProfile(b.flightsPerYear, b.preferredClass, 
                                              b.preferredRegion, b.travelsWithChildren);
        this.financialProfile = new FinancialProfile(b.income);
    }

    // Delegate to value objects
    public Demographics getDemographics() { return demographics; }
    public TravelProfile getTravelProfile() { return travelProfile; }
    public FinancialProfile getFinancialProfile() { return financialProfile; }

    // Convenience methods for backward compatibility (can be removed later)
    public int getAge() { return demographics.getAge(); }
    public int getFlightsPerYear() { return travelProfile.getFlightsPerYear(); }
    public boolean isStudent() { return demographics.isStudent(); }
    public boolean isLivesWithParents() { return demographics.livesWithParents(); }
    public double getIncome() { return financialProfile.getIncome(); }
    public CabinClass getPreferredClass() { return travelProfile.getPreferredClass(); }
    public DestinationRegion getPreferredRegion() { return travelProfile.getPreferredRegion(); }
    public boolean isTravelsWithChildren() { return travelProfile.travelsWithChildren(); }


    public static class Builder {
        private int age;
        private int flightsPerYear;
        private boolean isStudent;
        private boolean livesWithParents;
        private double income;
        private CabinClass preferredClass = CabinClass.ECONOMY;
        private DestinationRegion preferredRegion = DestinationRegion.OTHER;
        private boolean travelsWithChildren;

        public Builder age(int age) { this.age = age; return this; }
        public Builder flightsPerYear(int f) { this.flightsPerYear = f; return this; }
        public Builder isStudent(boolean v) { this.isStudent = v; return this; }
        public Builder livesWithParents(boolean v) { this.livesWithParents = v; return this; }
        public Builder income(double v) { this.income = v; return this; }
        public Builder preferredClass(CabinClass c) { this.preferredClass = c; return this; }
        public Builder preferredRegion(DestinationRegion r) { this.preferredRegion = r; return this; }
        public Builder travelsWithChildren(boolean v) { this.travelsWithChildren = v; return this; }
        public Customer build() { return new Customer(this); }
    }
}
