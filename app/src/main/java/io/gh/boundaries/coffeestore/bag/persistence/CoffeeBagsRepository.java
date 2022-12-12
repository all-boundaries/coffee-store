package io.gh.boundaries.coffeestore.bag.persistence;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeBagsRepository extends JpaRepository<CoffeeBagEntity, UUID> {}
