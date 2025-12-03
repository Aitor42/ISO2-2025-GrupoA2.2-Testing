package ISO2.Exe2.model;

/**
 * Value object that encapsulates travel preferences and behavior.
 * This reduces the number of independent parameters in Customer.
 */
public class TravelProfile {
    private final int flightsPerYear;
    private final CabinClass preferredClass;
    private final DestinationRegion preferredRegion;
    private final boolean travelsWithChildren;

    public TravelProfile(int flightsPerYear, CabinClass preferredClass, 
                        DestinationRegion preferredRegion, boolean travelsWithChildren) {
        this.flightsPerYear = flightsPerYear;
        this.preferredClass = preferredClass;
        this.preferredRegion = preferredRegion;
        this.travelsWithChildren = travelsWithChildren;
    }

    public int getFlightsPerYear() {
        return flightsPerYear;
    }

    public CabinClass getPreferredClass() {
        return preferredClass;
    }

    public DestinationRegion getPreferredRegion() {
        return preferredRegion;
    }

    public boolean travelsWithChildren() {
        return travelsWithChildren;
    }

    public boolean isRegularFlyer() {
        return flightsPerYear >= 3;
    }

    public boolean isFrequentFlyer() {
        return flightsPerYear >= 6;
    }

    public boolean isVeryFrequentFlyer() {
        return flightsPerYear >= 12;
    }

    public boolean prefersEconomy() {
        return preferredClass == CabinClass.ECONOMY;
    }

    public boolean prefersBusiness() {
        return preferredClass == CabinClass.BUSINESS;
    }

    public boolean prefersEurope() {
        return preferredRegion == DestinationRegion.EUROPE;
    }

    public boolean prefersLongHaulDestinations() {
        return preferredRegion == DestinationRegion.ASIA 
            || preferredRegion == DestinationRegion.AMERICA;
    }
}
