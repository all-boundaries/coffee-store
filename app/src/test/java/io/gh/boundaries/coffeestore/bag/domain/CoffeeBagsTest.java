package io.gh.boundaries.coffeestore.bag.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import io.gh.boundaries.coffeestore.bag.persistence.CoffeeBagEntity;
import io.gh.boundaries.coffeestore.bag.persistence.CoffeeBagsRepository;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CoffeeBagsTest {
    @Mock
    CoffeeBagsRepository repository;

    @Test
    void returnsAllKnownCoffeeBags() throws Exception {
        var coffeeBags = new CoffeeBags(repository);

        var coffeeBagEntity = new CoffeeBagEntity(
                UUID.randomUUID(),
                "Iridescent",
                "Includes coffees from Ethiopia, Kenya, and Latin America. It’s a  combination of some of our best, most interesting coffees, and features notes of dark chocolate and berry. Each year, we donate $1 per pound from Iridescent to fund transformative projects in coffee-producing countries through our Seeds fund—a program that awards grants to producer-driven sustainability projects. Because good work, good cheer, and great coffee is more than just a winter theme.",
                RoastingProfile.Dark,
                LocalDate.now().minusDays(2),
                "https://counterculturecoffee.com",
                "GRM",
                "g",
                new BigDecimal("340"));

        given(repository.findAll()).willReturn(List.of(coffeeBagEntity));

        assertThat(coffeeBags.all())
                .containsOnly(new CoffeeBag(
                        coffeeBagEntity.getName(),
                        coffeeBagEntity.getDescription(),
                        new Roasting(
                                coffeeBagEntity.getRoastingProfile(),
                                coffeeBagEntity.getRoastingDate(),
                                coffeeBagEntity.getRoastingVendor()),
                        new Weight(
                                coffeeBagEntity.getWeightCode(),
                                coffeeBagEntity.getWeightText(),
                                coffeeBagEntity.getWeightValue())));
    }
}
