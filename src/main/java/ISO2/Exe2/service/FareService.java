package ISO2.Exe2.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import ISO2.Exe2.model.Customer;
import ISO2.Exe2.model.FareOffer;
import ISO2.Exe2.service.strategies.DiscoverEuropeStrategy;
import ISO2.Exe2.service.strategies.DiscoverWorldStrategy;
import ISO2.Exe2.service.strategies.GorrionStrategy;
import ISO2.Exe2.service.strategies.PajarilloStrategy;
import ISO2.Exe2.service.strategies.YoungTravelerStrategy;

public class FareService {
    private final List<FareStrategy> strategies;

    public FareService() {
        // Order matters: more specific rules first
        this.strategies = Arrays.asList(
            new PajarilloStrategy(),
            new GorrionStrategy(),
            new YoungTravelerStrategy(),
            new DiscoverEuropeStrategy(),
            new DiscoverWorldStrategy()
        );
    }

    public Optional<FareOffer> findOffer(Customer c) {
        for (FareStrategy s : strategies) {
            Optional<FareOffer> offer = s.evaluate(c);
            if (offer.isPresent()) return offer;
        }
        return Optional.empty();
    }
}
