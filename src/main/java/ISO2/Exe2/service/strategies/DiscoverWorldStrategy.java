package ISO2.Exe2.service.strategies;

import java.util.Optional;

import ISO2.Exe2.model.Customer;
import ISO2.Exe2.model.FareOffer;
import ISO2.Exe2.service.FareStrategy;

public class DiscoverWorldStrategy implements FareStrategy {
    @Override
    public Optional<FareOffer> evaluate(Customer c) {
        if (isEligibleForDiscoverWorld(c)) {
            if (c.isTravelsWithChildren()) {
                return Optional.of(new FareOffer("Discover the World with Your Little Ones", 10.0));
            }
            return Optional.of(new FareOffer("Discover the World", 20.0));
        }
        return Optional.empty();
    }

    private boolean isEligibleForDiscoverWorld(Customer c) {
        return c.getDemographics().isMatureAdult()
            && c.getFinancialProfile().hasHighIncome()
            && c.getTravelProfile().isFrequentFlyer()
            && c.getTravelProfile().prefersBusiness()
            && c.getTravelProfile().prefersLongHaulDestinations();
    }
}
