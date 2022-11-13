package io.gh.boundaries.coffeestore.bag.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class CoffeeBags {
    public List<CoffeeBag> all() {
        var sampleBag = new CoffeeBag(
                "Iridescent",
                "Includes coffees from Ethiopia, Kenya, and Latin America. It’s a  combination of some of our best, most interesting coffees, and features notes of dark chocolate and berry. Each year, we donate $1 per pound from Iridescent to fund transformative projects in coffee-producing countries through our Seeds fund—a program that awards grants to producer-driven sustainability projects. Because good work, good cheer, and great coffee is more than just a winter theme.",
                new Roasting(
                        RoastingProfile.Dark,
                        LocalDate.now().minusDays(2),
                        "https://counterculturecoffee.com"),
                new Weight("GRM", "g", new BigDecimal("340")));
        return List.of(sampleBag);
    }
}
