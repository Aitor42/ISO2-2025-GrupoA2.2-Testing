package ISO2.Exe2.service.strategies;

import java.util.Optional;

import ISO2.Exe2.model.Customer;
import ISO2.Exe2.model.FareOffer;
import ISO2.Exe2.service.FareStrategy;

public class YoungTravelerStrategy implements FareStrategy {
    @Override
    public Optional<FareOffer> evaluate(Customer c) {
        if (isBaseEligible(c)) {
            if (isEligibleForTravelWhileYouCan(c)) {
                return Optional.of(new FareOffer("Travel While You Can", 5.0));
            }
            if (isEligibleForDaringToLeaveTheNest(c)) {
                return Optional.of(new FareOffer("Daring to Leave the Nest", 25.0));
            }
        }
        return Optional.empty();
    }

    private boolean isBaseEligible(Customer c) {
        return c.getDemographics().isYoungAdult() 
            && !c.getDemographics().isStudent() 
            && c.getTravelProfile().prefersEconomy();
    }

    private boolean isEligibleForTravelWhileYouCan(Customer c) {
        return c.getDemographics().livesWithParents() && c.getTravelProfile().isRegularFlyer();
    }

    private boolean isEligibleForDaringToLeaveTheNest(Customer c) {
        return !c.getDemographics().livesWithParents();
    }
}
