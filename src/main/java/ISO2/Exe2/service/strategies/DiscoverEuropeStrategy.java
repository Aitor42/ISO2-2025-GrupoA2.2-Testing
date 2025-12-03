package ISO2.Exe2.service.strategies;

import java.util.Optional;

import ISO2.Exe2.model.Customer;
import ISO2.Exe2.model.FareOffer;
import ISO2.Exe2.service.FareStrategy;

public class DiscoverEuropeStrategy implements FareStrategy {
    @Override
    public Optional<FareOffer> evaluate(Customer c) {
        if (isEligibleForDiscoverEurope(c)) {
            if (c.isTravelsWithChildren()) {
                return Optional.of(new FareOffer("Discover Europe with Your Little Ones", 10.0));
            }
            return Optional.of(new FareOffer("Discover Europe", 15.0));
        }
        return Optional.empty();
    }

    private boolean isEligibleForDiscoverEurope(Customer c) {
        return c.getDemographics().isMatureAdult()
            && c.getFinancialProfile().hasMiddleIncome()
            && c.getTravelProfile().isFrequentFlyer()
            && c.getTravelProfile().prefersEconomy()
            && c.getTravelProfile().prefersEurope();
    }
}
