package ISO2.Exe2.service.strategies;

import ISO2.Exe2.model.Customer;
import ISO2.Exe2.model.FareOffer;
import ISO2.Exe2.model.CabinClass;
import ISO2.Exe2.model.DestinationRegion;
import ISO2.Exe2.service.FareStrategy;
import java.util.Optional;

public class DiscoverEuropeStrategy implements FareStrategy {
    @Override
    public Optional<FareOffer> evaluate(Customer c) {
        if (c.getAge() > 25
            && c.getIncome() > 20000 && c.getIncome() < 35000
            && c.getFlightsPerYear() >= 6
            && c.getPreferredClass() == CabinClass.ECONOMY
            && c.getPreferredRegion() == DestinationRegion.EUROPE) {
            if (c.isTravelsWithChildrenUnder12()) {
                return Optional.of(new FareOffer("Discover Europe with Your Little Ones", 10.0));
            }
            return Optional.of(new FareOffer("Discover Europe", 15.0));
        }
        return Optional.empty();
    }
}
