package ISO2.Exe2.service.strategies;

import java.util.Optional;

import ISO2.Exe2.model.Customer;
import ISO2.Exe2.model.FareOffer;
import ISO2.Exe2.service.FareStrategy;

public class PajarilloStrategy implements FareStrategy {
    @Override
    public Optional<FareOffer> evaluate(Customer c) {
        if (c.getAge() < 18 && c.getFlightsPerYear() >= 6) {
            return Optional.of(new FareOffer("Pajarillo", 10.0));
        }
        return Optional.empty();
    }
}
