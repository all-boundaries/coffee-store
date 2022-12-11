package io.gh.boundaries.coffeestore.bag.domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class CoffeeBagsTest {
    @Test
    void returnsAllKnownCoffeeBags() throws Exception {
        var coffeeBags = new CoffeeBags();

        CoffeeBag sampleCoffeeBag = new CoffeeBag(
                "Iridescent",
                "Includes coffees from Ethiopia, Kenya, and Latin America. It’s a  combination of some of our best, most interesting coffees, and features notes of dark chocolate and berry. Each year, we donate $1 per pound from Iridescent to fund transformative projects in coffee-producing countries through our Seeds fund—a program that awards grants to producer-driven sustainability projects. Because good work, good cheer, and great coffee is more than just a winter theme.",
                new Roasting(RoastingProfile.Dark, LocalDate.now().minusDays(2), "https://counterculturecoffee.com"),
                new Weight("GRM", "g", new BigDecimal("340")));

        assertThat(coffeeBags.all()).containsOnly(sampleCoffeeBag);
    }
}
