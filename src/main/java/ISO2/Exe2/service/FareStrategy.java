package ISO2.Exe2.service;

import ISO2.Exe2.model.Customer;
import ISO2.Exe2.model.FareOffer;
import java.util.Optional;

public interface FareStrategy {
    Optional<FareOffer> evaluate(Customer c);
}
