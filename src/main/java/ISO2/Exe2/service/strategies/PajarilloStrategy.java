package ISO2.Exe2.service.strategies;

import java.util.Optional;

import ISO2.Exe2.model.Customer;
import ISO2.Exe2.model.FareOffer;
import ISO2.Exe2.service.FareStrategy;

public class PajarilloStrategy implements FareStrategy {
    @Override
    public Optional<FareOffer> evaluate(Customer c) {
        if (isEligibleForPajarillo(c)) {
            return Optional.of(new FareOffer("Pajarillo", 10.0));
        }
        return Optional.empty();
    }

    private boolean isEligibleForPajarillo(Customer c) {
        return c.getDemographics().isMinor() && c.getTravelProfile().isFrequentFlyer();
    }
}
