package ISO2.Exe2.service.strategies;

import java.util.Optional;

import ISO2.Exe2.model.Customer;
import ISO2.Exe2.model.FareOffer;
import ISO2.Exe2.service.FareStrategy;

public class GorrionStrategy implements FareStrategy {
    @Override
    public Optional<FareOffer> evaluate(Customer c) {
        if (isEligibleForGorrion(c)) {
            return Optional.of(new FareOffer("Gorrión", 15.0));
        }
        return Optional.empty();
    }

    private boolean isEligibleForGorrion(Customer c) {
        return c.getDemographics().isYoungAdult()
            && c.getDemographics().isStudent()
            && c.getTravelProfile().prefersEconomy()
            && c.getTravelProfile().isVeryFrequentFlyer();
    }
}
