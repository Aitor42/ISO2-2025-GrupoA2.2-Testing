package ISO2.Exe2.service.strategies;

import java.util.Optional;

import ISO2.Exe2.model.CabinClass;
import ISO2.Exe2.model.Customer;
import ISO2.Exe2.model.DestinationRegion;
import ISO2.Exe2.model.FareOffer;
import ISO2.Exe2.service.FareStrategy;

public class DiscoverWorldStrategy implements FareStrategy {
    @Override
    public Optional<FareOffer> evaluate(Customer c) {
        if (c.getAge() > 25
            && c.getIncome() > 35000
            && c.getFlightsPerYear() >= 6
            && c.getPreferredClass() == CabinClass.BUSINESS
            && (c.getPreferredRegion() == DestinationRegion.ASIA || c.getPreferredRegion() == DestinationRegion.AMERICA)) {
            if (c.isTravelsWithChildrenUnder12()) {
                return Optional.of(new FareOffer("Discover the World with Your Little Ones", 10.0));
            }
            return Optional.of(new FareOffer("Discover the World", 20.0));
        }
        return Optional.empty();
    }
}
