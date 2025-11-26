package ISO2.Exe2.service;

import java.util.Optional;

import ISO2.Exe2.model.Customer;
import ISO2.Exe2.model.FareOffer;

public interface FareStrategy {
    Optional<FareOffer> evaluate(Customer c);
}
