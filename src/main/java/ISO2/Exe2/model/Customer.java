package ISO2.Exe2.model;

public class Customer {
    private final int age;
    private final int flightsPerYear;
    private final boolean isStudentStudyingInAnotherCity;
    private final boolean travelsFromFamilyHomeMonthly;
    private final boolean startedWorking;
    private final boolean livesWithParents;
    private final int leisureTripsPerYear;
    private final double income;
    private final CabinClass preferredClass;
    private final DestinationRegion preferredRegion;
    private final boolean travelsWithChildrenUnder12;

    private Customer(Builder b) {
        this.age = b.age;
        this.flightsPerYear = b.flightsPerYear;
        this.isStudentStudyingInAnotherCity = b.isStudentStudyingInAnotherCity;
        this.travelsFromFamilyHomeMonthly = b.travelsFromFamilyHomeMonthly;
        this.startedWorking = b.startedWorking;
        this.livesWithParents = b.livesWithParents;
        this.leisureTripsPerYear = b.leisureTripsPerYear;
        this.income = b.income;
        this.preferredClass = b.preferredClass;
        this.preferredRegion = b.preferredRegion;
        this.travelsWithChildrenUnder12 = b.travelsWithChildrenUnder12;
    }

    public int getAge() { return age; }
    public int getFlightsPerYear() { return flightsPerYear; }
    public boolean isStudentStudyingInAnotherCity() { return isStudentStudyingInAnotherCity; }
    public boolean isTravelsFromFamilyHomeMonthly() { return travelsFromFamilyHomeMonthly; }
    public boolean isStartedWorking() { return startedWorking; }
    public boolean isLivesWithParents() { return livesWithParents; }
    public int getLeisureTripsPerYear() { return leisureTripsPerYear; }
    public double getIncome() { return income; }
    public CabinClass getPreferredClass() { return preferredClass; }
    public DestinationRegion getPreferredRegion() { return preferredRegion; }
    public boolean isTravelsWithChildrenUnder12() { return travelsWithChildrenUnder12; }

    public static class Builder {
        private int age;
        private int flightsPerYear;
        private boolean isStudentStudyingInAnotherCity;
        private boolean travelsFromFamilyHomeMonthly;
        private boolean startedWorking;
        private boolean livesWithParents;
        private int leisureTripsPerYear;
        private double income;
        private CabinClass preferredClass = CabinClass.ECONOMY;
        private DestinationRegion preferredRegion = DestinationRegion.OTHER;
        private boolean travelsWithChildrenUnder12;

        public Builder age(int age) { this.age = age; return this; }
        public Builder flightsPerYear(int f) { this.flightsPerYear = f; return this; }
        public Builder studentStudyingInAnotherCity(boolean v) { this.isStudentStudyingInAnotherCity = v; return this; }
        public Builder travelsFromFamilyHomeMonthly(boolean v) { this.travelsFromFamilyHomeMonthly = v; return this; }
        public Builder startedWorking(boolean v) { this.startedWorking = v; return this; }
        public Builder livesWithParents(boolean v) { this.livesWithParents = v; return this; }
        public Builder leisureTripsPerYear(int v) { this.leisureTripsPerYear = v; return this; }
        public Builder income(double v) { this.income = v; return this; }
        public Builder preferredClass(CabinClass c) { this.preferredClass = c; return this; }
        public Builder preferredRegion(DestinationRegion r) { this.preferredRegion = r; return this; }
        public Builder travelsWithChildrenUnder12(boolean v) { this.travelsWithChildrenUnder12 = v; return this; }
        public Customer build() { return new Customer(this); }
    }
}
