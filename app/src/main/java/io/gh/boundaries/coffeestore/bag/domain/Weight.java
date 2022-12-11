package io.gh.boundaries.coffeestore.bag.domain;

import java.math.BigDecimal;

public record Weight(String unitCode, String unitText, BigDecimal value) {}
