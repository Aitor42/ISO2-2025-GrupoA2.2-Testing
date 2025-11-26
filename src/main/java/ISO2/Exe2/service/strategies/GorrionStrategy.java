package ISO2.Exe2.service.strategies;

import java.util.Optional;

import ISO2.Exe2.model.CabinClass;
import ISO2.Exe2.model.Customer;
import ISO2.Exe2.model.FareOffer;
import ISO2.Exe2.service.FareStrategy;

public class GorrionStrategy implements FareStrategy {
    @Override
    public Optional<FareOffer> evaluate(Customer c) {
        if (c.getAge() >= 18 && c.getAge() <= 25
            && c.isStudentStudyingInAnotherCity()
            && c.getPreferredClass() == CabinClass.ECONOMY
            && c.isTravelsFromFamilyHomeMonthly()) {
            return Optional.of(new FareOffer("Gorrión", 15.0));
        }
        return Optional.empty();
    }
}
