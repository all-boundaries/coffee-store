package io.gh.boundaries.coffeestore.bag.domain;

import java.time.LocalDate;

public record Roasting(RoastingProfile profile, LocalDate date, String roasterUrl) {
}
