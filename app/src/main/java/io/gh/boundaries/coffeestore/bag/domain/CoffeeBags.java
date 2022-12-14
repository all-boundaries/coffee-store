package io.gh.boundaries.coffeestore.bag.domain;

import io.gh.boundaries.coffeestore.bag.persistence.CoffeeBagsRepository;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class CoffeeBags {
    private CoffeeBagsRepository coffeeBagsRepository;

    public CoffeeBags(CoffeeBagsRepository coffeeBagsRepository) {
        this.coffeeBagsRepository = coffeeBagsRepository;
    }

    public List<CoffeeBag> all() {
        return coffeeBagsRepository.findAll().stream()
                .map(entity -> new CoffeeBag(
                        entity.getName(),
                        entity.getDescription(),
                        new Roasting(entity.getRoastingProfile(), entity.getRoastingDate(), entity.getRoastingVendor()),
                        new Weight(entity.getWeightCode(), entity.getWeightText(), entity.getWeightValue())))
                .toList();
    }
}
