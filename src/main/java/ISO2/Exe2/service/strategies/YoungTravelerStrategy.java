package ISO2.Exe2.service.strategies;

import java.util.Optional;

import ISO2.Exe2.model.CabinClass;
import ISO2.Exe2.model.Customer;
import ISO2.Exe2.model.FareOffer;
import ISO2.Exe2.service.FareStrategy;

public class YoungTravelerStrategy implements FareStrategy {
    @Override
    public Optional<FareOffer> evaluate(Customer c) {
        if (c.getAge() >= 18 && c.getAge() <= 25 && c.isStartedWorking()
            && c.getPreferredClass() == CabinClass.ECONOMY) {
            if (c.isLivesWithParents() && c.getLeisureTripsPerYear() >= 3) {
                return Optional.of(new FareOffer("Travel While You Can", 5.0));
            }
            if (!c.isLivesWithParents()) {
                return Optional.of(new FareOffer("Daring to Leave the Nest", 25.0));
            }
        }
        return Optional.empty();
    }
}
