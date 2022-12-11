package io.gh.boundaries.coffeestore.bag.persistence;

import static org.assertj.core.api.Assertions.assertThat;

import io.gh.boundaries.coffeestore.bag.domain.RoastingProfile;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CoffeeBagsRepositoryTest {
    @Autowired
    CoffeeBagsRepository repository;

    @Test
    void retrievesAllCoffeeBags() throws Exception {
        CoffeeBagEntity coffeeBagEntity = new CoffeeBagEntity(
                UUID.randomUUID(),
                "Iridescent",
                "Includes coffees from Ethiopia, Kenya, and Latin America. It’s a  combination of some of our best, most interesting coffees, and features notes of dark chocolate and berry. Each year, we donate $1 per pound from Iridescent to fund transformative projects in coffee-producing countries through our Seeds fund—a program that awards grants to producer-driven sustainability projects. Because good work, good cheer, and great coffee is more than just a winter theme.",
                RoastingProfile.Dark,
                LocalDate.now().minusDays(2),
                "https://counterculturecoffee.com",
                "GRM",
                "g",
                new BigDecimal("340"));

        repository.saveAll(List.of(coffeeBagEntity));

        assertThat(repository.findAll()).containsOnly(coffeeBagEntity);
    }
}
